package exersise.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import exersise.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import exersise.service.BookService;

@Component
public class BookMutation implements GraphQLMutationResolver {
    @Autowired
    BookService service;

    public Book saveBook(String title, String authorName) {
        return service.saveBook(title, authorName);
    }
}
