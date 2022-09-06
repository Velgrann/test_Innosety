package exersise.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import exersise.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import exersise.service.AuthorService;

@Component
public class AuthorQuery implements GraphQLQueryResolver {
    @Autowired
    private AuthorService service;

    public Author getAuthor(String name) {
        return service.getAuthor(name);
    }
}
