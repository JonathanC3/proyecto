package com.ucr.proyecto.service;

import com.ucr.proyecto.domain.Client;
import com.ucr.proyecto.domain.Issue;
import com.ucr.proyecto.exceptions.RecordNotFoundException;
import com.ucr.proyecto.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {
    @Autowired
    private IssueRepository repository;

    public Issue save(Issue issue) {
        return repository.save(issue);
    }

    public Issue update(Issue issue) {
        find(issue.getId());
        return repository.save(issue);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public List<Issue> findAll() {
        return repository.findAll();
    }


    public Issue find(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(
                        () -> new RecordNotFoundException(Client.class, id));
    }
}
