package edu.miu.lab.data;

import edu.miu.lab.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BookRepository {
    private final Map<String, Book> books = new HashMap<>();

    public Book save(Book book) {
        books.put(book.getIsbn(), book);
        return books.get(book.getIsbn());
    }

    public Book findByIsbn(String isbn) {
        return books.get(isbn);
    }

    public void delete(String isbn) {
        books.remove(isbn);
    }

    public Collection<Book> findAll() {
        return books.values();
    }
}
