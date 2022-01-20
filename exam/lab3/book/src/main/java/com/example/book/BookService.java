package com.example.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public Book getBook(int isbn){
        return bookRepository.findByIsbn(isbn);
    }

    public void deleteBook(int isbn){
        bookRepository.deleteById(isbn);
    }

    public Book updateBook(int isbn, Book book){
        if (bookRepository.findByIsbn(isbn) != null)
            return bookRepository.save(book);
        return null;
    }
}
