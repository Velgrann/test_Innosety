package exersise.service;

import exersise.model.Author;
import exersise.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuthorService {

    public Author saveAuthor(String name, List<Book> bookList);
    public Author getAuthor(String name);

    public Author getAuthor(Long id);
}
