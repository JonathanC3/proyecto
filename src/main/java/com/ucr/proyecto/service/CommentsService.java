package com.ucr.proyecto.service;

import com.ucr.proyecto.domain.Comments;
import com.ucr.proyecto.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {
    @Autowired
    private CommentsRepository repository;

    public Comments save(Comments comments) {
        return repository.save(comments);
    }
}
