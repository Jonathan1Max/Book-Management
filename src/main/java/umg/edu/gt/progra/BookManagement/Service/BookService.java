/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.progra.BookManagement.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umg.edu.gt.progra.BookManagement.Model.Book;
import umg.edu.gt.progra.BookManagement.Repository.IBookRepository;

/**
 *
 * @author J MAX
 */
@Service
public class BookService {

    @Autowired
    private IBookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long bookId) {
        return bookRepository.findById(bookId);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public boolean deleteById(Long bookId) {
        if (bookRepository.existsById(bookId)) {
            bookRepository.deleteById(bookId);
            return true;
        }
        return false;
    }

    public Optional<Book> update(Long bookId, Book book) {
        Optional<Book> existingBook = findById(bookId);
        if (existingBook.isPresent()) {
            Book b = existingBook.get();
            b.setTitle(book.getTitle());
            b.setAuthor(book.getAuthor());
            b.setIsbn(book.getIsbn());
            b.setPublicationDate(book.getPublicationDate());
            b.setGenre(book.getGenre());
            b.setDescription(book.getDescription());
            return Optional.of(bookRepository.save(b));
        }
        return Optional.empty();
    }
}
