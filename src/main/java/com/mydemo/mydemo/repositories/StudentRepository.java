package com.mydemo.mydemo.repositories;

import com.mydemo.mydemo.Models.Student;
import com.mydemo.mydemo.Models.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    //    @EntityGraph(value = "studentTasks")
    Optional<Student> findById(Integer id);

    @Query(value = "SELECT * FROM students WHERE name = :input OR university = :input", nativeQuery = true)
    List<Student> findStudentByNameOrUniversity(@Param("input") String input);

    List<Student> findStudentByNameAndUniversity(String name, String university);

    @Query(value = "select * from students where id between ?1 and ?2", nativeQuery = true)
    List<Student> findByBetweenId(Integer id1, Integer id2);

    @Query(value = "select S from Student S where S.id between ?1 and ?2 ")
    List<Student> findByBetweenIdJpql(Integer id1, Integer id2);

}
