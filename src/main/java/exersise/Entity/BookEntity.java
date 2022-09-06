package exersise.Entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;


@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @OneToOne(mappedBy = "bookEntity")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private AuthorEntity author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author_id) {
        this.author = author_id;
    }
}
