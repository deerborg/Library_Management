package art.dborg.library_management.v1.business.concretes;

import art.dborg.library_management.v1.entities.Author;
import art.dborg.library_management.v1.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorServices {
    Author save(Author author);
    Author update(Author author);
    Author getId(long id);
    Page<Author> cursor(int page, int pageSize);
    boolean delete(long id);
}
