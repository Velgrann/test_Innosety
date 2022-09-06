package exersise.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import exersise.model.Author;
import exersise.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import exersise.service.AuthorService;

import java.util.List;

@Component
public class AuthorMutation implements GraphQLMutationResolver {
    @Autowired
    AuthorService service;

    public Author saveAuthor(String name) {
        return service.saveAuthor(name, null);
    }
}
