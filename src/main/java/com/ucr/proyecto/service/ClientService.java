package com.ucr.proyecto.service;

import com.ucr.proyecto.domain.Client;
import com.ucr.proyecto.exceptions.RecordNotFoundException;
import com.ucr.proyecto.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements UserDetailsService {
    @Autowired
    private ClientRepository repository;

    public Client save(Client client) {
        return repository.save(client);
    }

    public Client update(Client client) {
        find(client.getId());
        return repository.save(client);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Optional<Client> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Client find(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(
                        () -> new RecordNotFoundException(Client.class, id));
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not exists"));
        return new org.springframework.security.core.userdetails.User(client.getEmail(), client.getPassword(), new ArrayList());
    }
}
