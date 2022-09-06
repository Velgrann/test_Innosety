package exersise.Converter;

import exersise.Entity.AuthorEntity;
import exersise.Entity.BookEntity;
import exersise.model.Author;
import exersise.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookConverter {
    @Autowired
    AuthorConverter authorConverter;
    public Book entityToBook (BookEntity bookEntity, Author author) {
        Book book = new Book();
        book.setId(bookEntity.getId());
        book.setTitle(bookEntity.getTitle());
        return book;
    }

    public BookEntity bookToEntity (Book book) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(book.getId());
        bookEntity.setTitle(book.getTitle());
        bookEntity.setAuthor(authorConverter.AuthorToEntity(book.getAuthor()));
        return bookEntity;
    }
}
