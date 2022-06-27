package com.hadroy.SchoolManagementSystem.service;

import com.hadroy.SchoolManagementSystem.error.NotFoundException;
import com.hadroy.SchoolManagementSystem.entity.Course;
import com.hadroy.SchoolManagementSystem.model.ResponseApi;
import com.hadroy.SchoolManagementSystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public ResponseApi<Course> createCourse(Course course) {
        courseRepository.save(course);
        return new ResponseApi<>(
                201,
                "CREATED",
                course
        );
    }

    public ResponseApi<Course> getCourseByTitle(String title) {
        Optional<Course> course = courseRepository.findCourseByTitle(title);

        if (course.isPresent()) {
            return new ResponseApi<>(
                    200,
                    "OK",
                    course.get()
            );
        }
        throw new NotFoundException("Course with title='" +title+ "' is Not Found!!!");
    }

    public ResponseApi<Course> getCourseById(Long id) {
        Optional<Course> course = courseRepository.findById(id);

        if (course.isPresent()) {
            return new ResponseApi<>(
                    200,
                    "OK",
                    course.get()
            );
        }
        throw new NotFoundException("Course with id='" +id+ "' is Not Found!!!");
    }

    public ResponseApi<List<Course>> getCourseList() {
        return new ResponseApi<>(
                200,
                "OK",
                courseRepository.findAll()
        );
    }

    public ResponseApi<Course> updateCourseByTitle(String title, Course course) {
        Optional<Course> courseToUpdate = courseRepository.findCourseByTitle(title);

        if (courseToUpdate.isPresent()) {
            Course newDataCourse = courseToUpdate.get();

            newDataCourse.setTitle(course.getTitle());
            newDataCourse.setTeacher(course.getTeacher());
            newDataCourse.setStudents(course.getStudents());

            courseRepository.save(newDataCourse);
            return new ResponseApi<>(
                    200,
                    "OK",
                    newDataCourse
            );
        } else {
            throw new NotFoundException("Course with title='" +title+ "' is Not Found!!!");
        }
    }

    public ResponseApi<String> deleteCourseByTitle(String title) {

        Optional<Course> course = courseRepository.findCourseByTitle(title);
        if (course.isPresent()) {
            courseRepository.delete(course.get());
            return new ResponseApi<>(
                    200,
                    "OK",
                    title
            );
        } else {
            throw new NotFoundException("Course with title='" +title+ "' is Not Found!!!");
        }

    }
}
