package com.mydemo.mydemo.repositories;

import com.mydemo.mydemo.Models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
