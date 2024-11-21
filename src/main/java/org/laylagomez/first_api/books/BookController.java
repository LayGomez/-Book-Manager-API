package org.laylagomez.first_api.books;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;

    public BookController() {
        this.bookRepository= new InMemoryBookRepository();
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return this.bookRepository.findAll();
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn){
        Optional<Book> optionalBook = bookRepository.findByIsbn(isbn);

        if (optionalBook.isPresent()) {
            return new ResponseEntity<>(optionalBook.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        //comprobar que no exista el isbn return (Bad_request)

        bookRepository.save(book);
        return book;
    }

    @DeleteMapping("/{isbn}")
    public void deleteBookByIsbn(@PathVariable String isbn){
        // si no existe retnornaar un 404
        // si se ha borrado un ok
        bookRepository.deleteByIsbn(isbn);
    }

}
