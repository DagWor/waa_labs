package edu.miu.lab.controller;

import edu.miu.lab.domain.Book;
import edu.miu.lab.exception.BookNotFoundException;
import edu.miu.lab.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/books")
    public ResponseEntity<?> addBook(@RequestBody @Valid Book book) {
        this.bookService.addBook(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<?> updateBook(@PathVariable("isbn") String isbn, @Valid @RequestBody Book book) throws BookNotFoundException {
        Book bookDetail = this.bookService.findByIsbn(isbn);
        if (bookDetail == null) {
            throw new BookNotFoundException("Book with isbn " + isbn + " not found");
        }
        this.bookService.updateBook(isbn, book);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/books/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable String isbn) throws BookNotFoundException {
        if (this.bookService.findByIsbn(isbn) == null) {
            throw new BookNotFoundException("Book with isbn " + isbn + " not found");
        }
        this.bookService.deleteBook(isbn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/books/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable String isbn) throws BookNotFoundException {
        Book book = this.bookService.findByIsbn(isbn);
        if (book == null) {
            throw new BookNotFoundException("Book with isbn " + isbn + " not found");
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks() {
        Collection<Book> books = this.bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/books/search")
    public ResponseEntity<?> searchBooks(@RequestParam String author) {
        Book book = this.bookService.searchBook(author);
        if (book != null)
            return new ResponseEntity<>(book, HttpStatus.OK);
        return new ResponseEntity<>(new BookNotFoundException("Book with author " + author + " not found"), HttpStatus.NOT_FOUND);
    }
}
