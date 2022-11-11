package com.ust.student.ust.repository;

import com.ust.student.ust.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Books,Integer> {


}
