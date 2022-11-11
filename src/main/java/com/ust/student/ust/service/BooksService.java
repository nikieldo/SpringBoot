package com.ust.student.ust.service;

import com.ust.student.ust.entity.Books;
import com.ust.student.ust.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BooksService {
    /**
     * the book service
     */
    @Autowired
    BooksRepository bookRepository;
    public Books getBooksByID(Integer id) {

        return bookRepository.findById(id).orElse(null);
    }

    public void saveBooks(Books book) {
        bookRepository.save(book);
    }

    public List<Books> getBooksAll() {
        return bookRepository.findAll();
    }

    public void deleteBooks(Integer id) {
        bookRepository.deleteById(id);
    }

    public Books updateBooks(Books book) {
        Books updateBooks=bookRepository.findById(book.getBookId()).orElseThrow(()-> new NoSuchElementException());
        updateBooks.setName(book.getName());
        updateBooks.setPrice(book.getPrice());
        updateBooks.setYear(book.getYear());
        bookRepository.save(updateBooks);
        return updateBooks;
    }

    public Books getBookByID(Integer id) {
        return bookRepository.findById(id).orElseThrow(()->new NoSuchElementException());
    }
}
