package exersise.Dao;

import exersise.Entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

    @Query("select id, name from AuthorEntity as a where a.name = :name")
    AuthorEntity findByName(@Param("name") String name);
}
