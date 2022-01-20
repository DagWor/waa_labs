package com.example.book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    BookService bookService;


    @PostMapping("/book")
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @GetMapping("/book/{isbn}")
    public ResponseEntity<Book> getBook(@PathVariable int isbn){
        return new ResponseEntity<>(bookService.getBook(isbn), HttpStatus.OK);
    }

    @DeleteMapping("/book/{isbn}")
    public void deleteBook(int isbn){
        bookService.deleteBook(isbn);
    }

    @PutMapping("/book/{isbn}")
    public ResponseEntity<Book> updateBook(@PathVariable int isbn, @RequestBody Book book){
        return new ResponseEntity<>(bookService.updateBook(isbn, book), HttpStatus.OK);
    }
}
