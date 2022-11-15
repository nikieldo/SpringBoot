package com.ust.student.ust.controller;

import com.ust.student.ust.DTO.StudentDTO;
import com.ust.student.ust.entity.Student;
import com.ust.student.ust.exception.InvalidEmailException;
import com.ust.student.ust.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDTO>get(@PathVariable Integer id) {
        try {
            Student student =studentService.getStudentByID(id);
            return new ResponseEntity<StudentDTO>(studentService.converttoDTO(student), HttpStatus.OK);
        }catch(NoSuchElementException e) {
            return new ResponseEntity<StudentDTO>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/studentRequestParam")
    public ResponseEntity<Student>getRequest(@RequestParam(name = "id") Integer id) {
        try {
            Student student =studentService.getStudentByID(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        }catch(NoSuchElementException e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/student")
    public ResponseEntity<List<Student>>get2() {
        try {
            List<Student> studentList=studentService.getStudentAll();
            return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
        }catch(NoSuchElementException e) {
            return new ResponseEntity<List<Student>>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/student")
      public ResponseEntity<Student> add(@RequestBody Student student) {
       try {
        studentService.saveStudent(student);
           return new ResponseEntity<Student>(student, HttpStatus.OK);
    } catch (InvalidEmailException e) {
           return new ResponseEntity<Student>(HttpStatus.PRECONDITION_FAILED);
       }

       }
    @DeleteMapping("/student/{id}")
    public void delete(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }
    @PutMapping("/student")
    public ResponseEntity<Student>put(@RequestBody Student student) {
        try {
            Student updatedstudent =studentService.updateStudent(student);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        }catch(NoSuchElementException e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }
}
