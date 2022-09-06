package exersise.Converter;

import exersise.Entity.AuthorEntity;
import exersise.model.Author;
import exersise.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorConverter {

    public Author entityToAuthor (AuthorEntity authorEntity, List<Book> bookList) {
       Author author = new Author();
       author.setId(authorEntity.getId());
       author.setName(authorEntity.getName());
       author.setBookList(bookList);
       return author;
    }

    public AuthorEntity AuthorToEntity (Author author) {
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setId(author.getId());
        authorEntity.setName(author.getName());
        return authorEntity;
    }
}
