package com.hadroy.SchoolManagementSystem.controller;

import com.hadroy.SchoolManagementSystem.entity.Student;
import com.hadroy.SchoolManagementSystem.model.StudentToCourseForm;
import com.hadroy.SchoolManagementSystem.service.StudentService;
import com.hadroy.SchoolManagementSystem.model.ResponseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<ResponseApi<List<Student>>> getAllStudents() {
        return new ResponseEntity<>(studentService.getStudentList(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<ResponseApi<Student>> getStudent(@PathVariable String name) {
        return new ResponseEntity<>(studentService.getStudentByName(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseApi<Student>> createStudent(@Valid @RequestBody Student student) {
        return new ResponseEntity<>(studentService.create(student), HttpStatus.CREATED);
    }

    @PutMapping("/{name}")
    public ResponseEntity<ResponseApi<Student>> updateStudent(@PathVariable String name, @Valid @RequestBody Student student) {
        return new ResponseEntity<>(studentService.update(name, student), HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<ResponseApi<String>> deleteStudent(@PathVariable String name) {
        return new ResponseEntity<>(studentService.deleteStudentByName(name), HttpStatus.OK);
    }

    @PostMapping("/add-course")
    public ResponseEntity<ResponseApi<String>> addCourse(@RequestBody StudentToCourseForm form) {
        return new ResponseEntity<>(studentService.addStudentToCourse(form), HttpStatus.OK);
    }
}
