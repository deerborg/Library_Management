package art.dborg.library_management.v1.dao;

import art.dborg.library_management.v1.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
