package art.dborg.library_management.v1.dao;

import art.dborg.library_management.v1.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
