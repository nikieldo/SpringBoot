package com.ust.student.ust.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * The type Student.
 */
@Entity
@Data
@Table(name="student_ust_details_identitymappedbytest")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int studentId;
    private String name;
    private int age;
    private int rollNo;
    private LocalDateTime creatDate;
    private LocalDateTime modifyDate;
    @Column(name="email",unique=true)
    private String email;
    private String password;


    @OneToMany(cascade =CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="student")
    private Set<Books> booksSet;



}
