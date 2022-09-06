package exersise.service;

import exersise.Converter.BookConverter;
import exersise.Dao.BookRepository;
import exersise.Entity.BookEntity;
import exersise.model.Author;
import exersise.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository repository;
    @Autowired
    AuthorService authorService;
    BookConverter converter;

    @Override
    public Book saveBook(String title, String authorName) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(authorService.getAuthor(authorName));
        return converter.entityToBook(repository.save(converter.bookToEntity(book)), book.getAuthor());
    }

    @Override
    public Book saveBook(Book book) {
        return converter.entityToBook(repository.save(converter.bookToEntity(book)), book.getAuthor());
    }


    @Override
    public List<Book> getBooksByAuthor(Author author) {
        List<BookEntity> bookEntityList = repository.findAll();
        return bookEntityList.stream().map(bookEntity -> converter.entityToBook(bookEntity, author)).collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooks() {
        List<BookEntity> bookEntityList = repository.findAll();
        return bookEntityList.stream().map(bookEntity -> converter.entityToBook(bookEntity, authorService.getAuthor(bookEntity.getId()))).collect(Collectors.toList());
    }
}
