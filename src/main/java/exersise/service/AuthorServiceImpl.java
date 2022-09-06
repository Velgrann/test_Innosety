package exersise.service;

import exersise.Converter.AuthorConverter;
import exersise.Dao.AuthorRepository;
import exersise.Entity.AuthorEntity;
import exersise.model.Author;
import exersise.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookService bookService;
    @Autowired
    AuthorConverter converter;

    @Override
    public Author saveAuthor(String name, List<Book> bookList) {
        Author author = new Author();
        author.setName(name);
        author.setBookList(bookList);
        authorRepository.save(converter.AuthorToEntity(author));
        for (Book book : author.getBookList()){
            bookService.saveBook(book);
        }
        return author;
    }

    @Override
    public Author getAuthor(String name) {
        Author author = converter.entityToAuthor(authorRepository.findByName(name), null);
        List<Book> bookList = bookService.getBooksByAuthor(author);
        author.setBookList(bookList);
        return author;
    }

    @Override
    public Author getAuthor(Long id) {
        Optional<AuthorEntity> authorEntityOptional = authorRepository.findById(id);
        if (authorEntityOptional.isPresent()) {
            Author author = converter.entityToAuthor(authorEntityOptional.get(), null);
            List<Book> bookList = bookService.getBooksByAuthor(author);
            author.setBookList(bookList);
            return author;
        }
        return null;
    }

}
