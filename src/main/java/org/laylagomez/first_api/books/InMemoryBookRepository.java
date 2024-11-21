package org.laylagomez.first_api.books;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
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
    public Optional<Book> save(Book newbook) {
        for (Book book: booksDB) {
            if (book.getIsbn().equals(newbook.getIsbn())) return Optional.empty();
        }
        booksDB.add(newbook);
        return Optional.of(newbook);
    }

    @Override
    public Optional<Book> deleteByIsbn(String isbn) {

            for (Book book : booksDB) {
                if (book.getIsbn().equals(isbn)) {
                    booksDB.remove(book);
                    return Optional.of(book);
                }
            }
            return Optional.empty();

    }

    @Override
    public Optional<Book> updateBookByIsbn(String isbn, Book updatedBook) {
        for (Book book : booksDB) {
            if (book.getIsbn().equals(isbn)) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setIsbn(updatedBook.getIsbn());
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }


}
