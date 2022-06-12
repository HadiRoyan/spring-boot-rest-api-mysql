package com.hadroy.SchoolManagementSystem.repository;

import com.hadroy.SchoolManagementSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentByName(String name);

    Optional<Student> findStudentByEmail(@Email String email);

    Boolean existsStudentByName(String name);

    Boolean existsStudentByEmail(String email);
}
