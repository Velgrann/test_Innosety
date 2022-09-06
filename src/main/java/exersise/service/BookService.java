package exersise.service;

import exersise.model.Author;
import exersise.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    public  Book saveBook(String title, String authorName) ;
    public  Book saveBook(Book book) ;
    public List<Book> getBooksByAuthor(Author author);
    public List<Book> getAllBooks();

}
