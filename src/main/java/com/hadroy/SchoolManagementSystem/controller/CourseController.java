package com.hadroy.SchoolManagementSystem.controller;

import com.hadroy.SchoolManagementSystem.model.Course;
import com.hadroy.SchoolManagementSystem.model.ResponseApi;
import com.hadroy.SchoolManagementSystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/courses")
public class CourseController {

    @Autowired
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ResponseApi<List<Course>>> getAllCourses() {
        return new ResponseEntity<>(
                courseService.getCourseList(), HttpStatus.OK
        );
    }

    @GetMapping("/{title}")
    public ResponseEntity<ResponseApi<Course>> getCourse(@PathVariable String title) {
        return new ResponseEntity<>(
                courseService.getCourseByTitle(title), HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<ResponseApi<Course>> createCourse(@Valid @RequestBody Course course) {
        return new ResponseEntity<>(
                courseService.createCourse(course), HttpStatus.CREATED
        );
    }

    @PutMapping("/{title}")
    public ResponseEntity<ResponseApi<Course>> update(@PathVariable String title, @Valid @RequestBody Course course) {
        return new ResponseEntity<>(
                courseService.updateCourseByTitle(title, course), HttpStatus.OK
        );
    }

    @DeleteMapping("/{title}")
    public ResponseEntity<ResponseApi<String>> deleteCourse(@PathVariable String title) {
        return new ResponseEntity<>(
                courseService.deleteCourseByTitle(title), HttpStatus.OK
        );
    }
}
