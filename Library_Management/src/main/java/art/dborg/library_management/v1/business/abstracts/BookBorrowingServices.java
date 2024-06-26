package art.dborg.library_management.v1.business.abstracts;

import art.dborg.library_management.v1.entities.BookBorrowing;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;


public interface BookBorrowingServices {
    BookBorrowing save(BookBorrowing bookBorrowing);
    BookBorrowing update(BookBorrowing bookBorrowing);
    BookBorrowing getId(long id);
    Page<BookBorrowing> cursor(int page, int pageSize);
    boolean delete(long id);
}
