package com.hadroy.SchoolManagementSystem.service;

import com.hadroy.SchoolManagementSystem.error.NotFoundException;
import com.hadroy.SchoolManagementSystem.model.Student;
import com.hadroy.SchoolManagementSystem.repository.StudentRepository;
import com.hadroy.SchoolManagementSystem.model.ResponseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public ResponseApi<Student> create(Student student) {
        studentRepository.save(student);
        return new ResponseApi<>(
                201,
                "CREATED",
                student
        );
    }

    public ResponseApi<Student> getStudentByName(String name) {

        Optional<Student> student = studentRepository.findStudentByName(name);
        if (student.isPresent()) {
            return new ResponseApi<>(
                    200,
                    "OK",
                    student.get()
            );
        }
        throw new NotFoundException("Student with name ='"+name+"' is Not Found!!");
    }

    public ResponseApi<Student> getStudentByEmail(String email) {

        Optional<Student> student = studentRepository.findStudentByEmail(email);
        if (student.isPresent()) {
            return new ResponseApi<>(
                    200,
                    "OK",
                    student.get()
            );
        }
        throw new NotFoundException("Student with email ='"+email+"' is Not Found!!");
    }

    public ResponseApi<Student> getStudentById(long id) {

        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return new ResponseApi<>(
                    200,
                    "OK",
                    student.get()
            );
        }
        throw new NotFoundException("Student with id ='"+id+"' is Not Found!!");
    }

    public ResponseApi<List<Student>> getStudentList() {
        return new ResponseApi<>(
                200,
                "OK",
                studentRepository.findAll()
        );
    }

    public ResponseApi<Student> update(String name, Student student) {

        Optional<Student> studentToUpdate = studentRepository.findStudentByName(name);

        if (studentToUpdate.isPresent()) {
            Student newDataStudent = studentToUpdate.get();

            newDataStudent.setName(student.getName());
            newDataStudent.setEmail(student.getEmail());
            newDataStudent.setPassword(student.getPassword());
            newDataStudent.setAge(student.getAge());
            newDataStudent.setGender(student.getGender());
            newDataStudent.setCourses(student.getCourses());

            studentRepository.save(newDataStudent);
            return new ResponseApi<>(
                    200,
                    "OK",
                    newDataStudent
            );
        } else {
            throw new NotFoundException("Student with name ='"+name+"' is Not Found!!");
        }
    }

    public ResponseApi<String> deleteStudentByName(String name) {

        Optional<Student> student = studentRepository.findStudentByName(name);

        if (student.isPresent()) {
            studentRepository.delete(student.get());
            return new ResponseApi<>(
                    200,
                    "OK",
                    name
            );
        } else {
            throw new NotFoundException("Student with name ='"+name+"' is Not Found!!");
        }

    }
}
