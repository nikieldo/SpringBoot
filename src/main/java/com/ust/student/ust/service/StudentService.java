package com.ust.student.ust.service;

import com.sun.media.sound.MidiOutDeviceProvider;
import com.ust.student.ust.DTO.StudentDTO;
import com.ust.student.ust.entity.Student;
import com.ust.student.ust.exception.InvalidEmailException;
import com.ust.student.ust.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class StudentService {
    /**
     * the student service
      */
@Autowired
    StudentRepository studentRepository;
@Autowired
private ModelMapper modelMapper;
    public Student getStudentByID(Integer id) {
    return studentRepository.findById(id).orElse(null);
    }

    public void saveStudent(Student student) {
        student.setCreatDate(LocalDateTime.now());
        //EMAIL
        student.setModifyDate(student.getCreatDate());
        String email=student.getEmail();
        String regex="^([A-Za-z0-9+_.-]+)@([a-z]+)\\.([a-z]+)$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(email);

        //PASSWORD
        String password=student.getPassword();
        String regexPassword =  "^(?=(?:.*\\d){3,})(?=\\S+$)(?=.*[@#$%^&+=])(?=(?:.*[A-Za-z]){3,})(?=.*[A-Z]).{8,}$";
        Pattern pattern1=Pattern.compile(regexPassword);
        Matcher matcher1=pattern1.matcher(password);
        if(matcher.matches()&&matcher1.matches()) {
            studentRepository.save(student);
        }
        else {
            throw new InvalidEmailException();
        }
        studentRepository.save(student);
    }

    public List<Student> getStudentAll() {
        System.out.println(studentRepository.findByName("nikitha"));
        System.out.println(studentRepository.findByNameEquals("nikitha"));
        //test
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

    public StudentDTO converttoDTO(Student student) {
        return modelMapper.map(student,StudentDTO.class);
    }
}
