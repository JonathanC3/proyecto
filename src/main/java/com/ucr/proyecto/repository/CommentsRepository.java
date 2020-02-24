package com.ucr.proyecto.repository;

import com.ucr.proyecto.domain.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {
}
