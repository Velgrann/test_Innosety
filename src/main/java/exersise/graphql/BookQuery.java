package exersise.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import exersise.model.Author;
import exersise.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import exersise.service.BookService;

import java.util.List;

@Component
public class BookQuery implements GraphQLQueryResolver {
    @Autowired
    private BookService service;

    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    public List<Book> getBooksByAuthor(Author author) {
        return service.getBooksByAuthor(author);
    }
}
