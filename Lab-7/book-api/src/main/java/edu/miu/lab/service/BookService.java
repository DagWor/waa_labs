package edu.miu.lab.service;

import edu.miu.lab.data.BookRepository;
import edu.miu.lab.domain.Book;
import edu.miu.lab.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        return this.bookRepository.save(book);
    }

    public void updateBook(String isbn, Book book) throws BookNotFoundException {
        this.bookRepository.save(book);
    }

    public void deleteBook(String isbn) {
        this.bookRepository.delete(isbn);
    }


    public Book findByIsbn(String isbn) {
        Book book = this.bookRepository.findByIsbn(isbn);
        return book;
    }

    public Collection<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    public Book searchBook(String author) {
        Optional<Book> book = this.bookRepository.findAll().stream().filter(b -> b.getAuthor().equals(author)).findAny();
        return book.orElse(null);
    }

}
