package exersise.Dao;

import exersise.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
   /* @Query("select from BookEntity b " +
            "inner join b.author where author.name = :name")
    List<BookEntity> findByAuthorsName(@Param("name") String name);*/
}
