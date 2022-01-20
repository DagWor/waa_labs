package edu.miu.lab.service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import edu.miu.lab.domain.Book;
import edu.miu.lab.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMutation implements GraphQLMutationResolver {

    @Autowired
    BookService bookService;

    public Book addBook(String isbn, String author, String title, double price) {
        Book book = new Book(isbn, author, title, price);
        return bookService.addBook(book);
    }

    public void deleteBook(String isbn) {
        bookService.deleteBook(isbn);
    }

    public void updateBook(String isbn, String author, String title, double price) throws BookNotFoundException {
        Book book = new Book(isbn, author, title, price);
        bookService.updateBook(isbn, book);
    }
}

