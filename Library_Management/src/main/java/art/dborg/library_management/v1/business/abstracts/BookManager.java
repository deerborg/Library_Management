package art.dborg.library_management.v1.business.abstracts;

import art.dborg.library_management.v1.business.concretes.BookServices;
import art.dborg.library_management.v1.dao.BookRepository;
import art.dborg.library_management.v1.entities.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookManager implements BookServices {
    private final BookRepository bookRepository;
    @Override
    public Book save(Book Book) {
        return null;
    }

    @Override
    public Book update(Book Book) {
        return null;
    }

    @Override
    public Book getId(long id) {
        return null;
    }

    @Override
    public Page<Book> cursor(int page, int pageSize) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
