package com.ust.student.ust.controller;

import com.ust.student.ust.entity.Books;
import com.ust.student.ust.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
@RestController
public class BooksController {

        @Autowired
        BooksService bookService;
        @GetMapping("/book/{id}")
        public ResponseEntity<Books> get(@PathVariable Integer id) {
            try {
                Books book =bookService.getBookByID(id);
                return new ResponseEntity<Books>(book, HttpStatus.OK);
            }catch(NoSuchElementException e) {
                return new ResponseEntity<Books>(HttpStatus.NOT_FOUND);
            }
        }
        @GetMapping("/book")
        public ResponseEntity<List<Books>>get2() {
            try {
                List<Books> bookList=bookService.getBooksAll();
                return new ResponseEntity<List<Books>>(bookList, HttpStatus.OK);
            }catch(NoSuchElementException e) {
                return new ResponseEntity<List<Books>>(HttpStatus.NOT_FOUND);
            }
        }
        @PostMapping("/book")
        public void add(@RequestBody Books book) {

            bookService.saveBooks(book);
        }
        @DeleteMapping("/book/{id}")
        public void delete(@PathVariable Integer id) {
            bookService.deleteBooks(id);
        }
        @PutMapping("/book")
        public ResponseEntity<Books>put(@RequestBody Books book) {
            try {
                Books updatedbook =bookService.updateBooks(book);
                return new ResponseEntity<Books>(updatedbook, HttpStatus.OK);
            }catch(NoSuchElementException e) {
                return new ResponseEntity<Books>(HttpStatus.NOT_FOUND);
            }
        }
    }


