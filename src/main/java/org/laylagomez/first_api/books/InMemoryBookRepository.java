package org.laylagomez.first_api.books;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class InMemoryBookRepository implements BookRepository {
    private final static List<Book> booksDB= new ArrayList<>();

    public InMemoryBookRepository() {
        booksDB.add(new Book("A123", "booktitle1", "bookauthor1"));
        booksDB.add(new Book("A124", "booktitle2", "bookauthor2"));
        booksDB.add(new Book("A125", "booktitle3", "bookauthor3"));

    }

    @Override
    public List<Book> findAll(){
        return Collections.unmodifiableList(booksDB);
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        for (Book book: booksDB){
            if (book.getIsbn().equals(isbn)) return Optional.of(book);
        }
        return Optional.empty();
    }

    @Override
    public void save(Book book) {
        booksDB.add(book);
    }

    @Override
    public void deleteByIsbn(String isbn) {
        booksDB.removeIf(book -> book.getIsbn().equals(isbn));
    }


}
