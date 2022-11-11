package com.ust.student.ust.service;

import com.ust.student.ust.entity.Student;
import com.ust.student.ust.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {
    /**
     * the student service
      */
@Autowired
    StudentRepository studentRepository;
    public Student getStudentByID(Integer id) {
    return studentRepository.findById(id).orElse(null);
    }

    public void saveStudent(Student student) {
        student.setCreatDate(LocalDateTime.now());
        student.setModifyDate(student.getCreatDate());
        studentRepository.save(student);
    }

    public List<Student> getStudentAll() {
        System.out.println(studentRepository.findByName("nikitha"));
        System.out.println(studentRepository.findByNameEquals("nikitha"));


        return studentRepository.findAll();
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Student student) {
        Student updateStudent=studentRepository.findById(student.getStudentId()).orElseThrow(()-> new NoSuchElementException());
        updateStudent.setName(student.getName());
        updateStudent.setAge(student.getAge());
        updateStudent.setModifyDate(LocalDateTime.now());
        studentRepository.save(updateStudent);
        return updateStudent;
    }

}
