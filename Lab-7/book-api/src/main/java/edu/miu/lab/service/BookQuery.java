package edu.miu.lab.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import edu.miu.lab.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class BookQuery implements GraphQLQueryResolver {
    @Autowired
    BookService bookService;

    public Collection<Book> books(int count) {
        return bookService.getAllBooks();
    }

    public Book book(String isbn) {
        return bookService.findByIsbn(isbn);
    }
}

