package com.hadroy.SchoolManagementSystem.repository;

import com.hadroy.SchoolManagementSystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    boolean existsCourseByTeacher(String teacher);

    boolean existsCourseByTitle(String title);

    Optional<Course> findCourseByTitle(String title);

}
