package com.ust.student.ust.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="book_ust_details")
public class Books {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int bookId;
    private String name;
    private int year;
    private int price;

    @ManyToOne
    @JoinColumn(name="student_id")
    Student student;

}
