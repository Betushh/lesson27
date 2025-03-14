package com.mydemo.mydemo.repositories;

import com.mydemo.mydemo.Models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
}
