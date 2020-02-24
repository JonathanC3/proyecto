package com.ucr.proyecto.service.security;


import com.ucr.proyecto.domain.Client;
import com.ucr.proyecto.dto.security.RegisterClientDTO;
import com.ucr.proyecto.exceptions.security.DuplicatedUserException;
import com.ucr.proyecto.service.ClientService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import static com.ucr.proyecto.commons.Constants.JWT_ID;
import static com.ucr.proyecto.commons.Constants.SECRET_KEY;


@Service
public class SessionService {
    @Autowired
    private ClientService clientService;

    @Autowired
    private PasswordEncoder encoder;

    public boolean validateUser(String email, String password) {
        Optional<Client> client = clientService.findByEmail(email);
        if (client.isPresent()) {
            return encoder.matches(password, client.get().getPassword());
        } else return false;

    }

    public String buildToken(String username) {
        Client client = clientService.findByEmail(username).get();

        List<GrantedAuthority> grantedAuthorities = null;

        String token = Jwts
                .builder()
                .setId(JWT_ID)
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 3_600_000))//1 hour
                .signWith(SignatureAlgorithm.HS512,
                        SECRET_KEY.getBytes()).compact();

        return "Bearer " + token;

    }

    public void createUser(RegisterClientDTO register) {
        if(clientService.findByEmail(register.getEmail()).isPresent()){
            throw new DuplicatedUserException();
        }
        Client client = new Client();
        client.setEmail(register.getEmail());
        client.setName(register.getName());
        client.setFirstSurname(register.getFirstSurname());
        client.setSecondSurname(register.getLastName());
        client.setAddress(register.getAddress());
        client.setPhone(register.getPhone());
        client.setSecondContact(register.getSecondContact());
        client.setServices(register.getServices());
        client.setPassword(encoder.encode(register.getPassword()));
        clientService.save(client);
    }
}
