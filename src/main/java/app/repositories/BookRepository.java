package app.repositories;

import app.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    // This compiles perfectly because BookEntity possesses the author field
    List<BookEntity> findByAuthorContainingIgnoreCase(String author);
}
