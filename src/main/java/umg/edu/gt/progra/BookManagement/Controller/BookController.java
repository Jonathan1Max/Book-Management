/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.progra.BookManagement.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umg.edu.gt.progra.BookManagement.Model.Book;
import umg.edu.gt.progra.BookManagement.Service.BookService;

/**
 *
 * @author J MAX
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{bookId}")
    public Optional<Book> getBookById(@PathVariable Long bookId) {
        return bookService.findById(bookId);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("/{bookId}")
    public Optional<Book> updateBook(@PathVariable Long bookId, @RequestBody Book book) {
        return bookService.update(bookId, book);
    }

    @DeleteMapping("/{bookId}")
    public String deleteBook(@PathVariable Long bookId) {
        boolean deleted = bookService.deleteById(bookId);
        return deleted ? "Book deleted" : "Book not deleted";
    }
}
