package com.ucr.proyecto.repository;

import com.ucr.proyecto.domain.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Integer> {
}
