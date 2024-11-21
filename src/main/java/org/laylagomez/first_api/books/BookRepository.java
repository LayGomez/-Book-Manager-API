package org.laylagomez.first_api.books;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> findAll();

    Optional<Book> findByIsbn(String isbn);

    Optional<Book> save(Book book);

    Optional<Book> deleteByIsbn(String isbn);

    Optional<Book> updateBookByIsbn(String isbn,  Book updatedBook);
}
