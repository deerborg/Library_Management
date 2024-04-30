package art.dborg.library_management.v1.business.concretes;

import art.dborg.library_management.v1.entities.Author;
import art.dborg.library_management.v1.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface BookServices {
    Book save(Book Book);
    Book update(Book Book);
    Book getId(long id);
    Page<Book> cursor(int page, int pageSize);
    boolean delete(long id);
}
