package art.dborg.library_management.v1.business.abstracts;

import art.dborg.library_management.v1.business.concretes.BookBorrowingServices;
import art.dborg.library_management.v1.core.expection.NotFoundException;
import art.dborg.library_management.v1.core.utilities.Message;
import art.dborg.library_management.v1.dao.BookBorrowingRepository;
import art.dborg.library_management.v1.entities.BookBorrowing;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookBorrowingManager implements BookBorrowingServices {
    private final BookBorrowingRepository bookBorrowingRepository;
    @Override
    public BookBorrowing save(BookBorrowing bookBorrowing) {
        return bookBorrowingRepository.save(bookBorrowing);
    }

    @Override
    public BookBorrowing update(BookBorrowing bookBorrowing) {
        getId(bookBorrowing.getId());
        return bookBorrowingRepository.save(bookBorrowing);
    }

    @Override
    public BookBorrowing getId(long id) {
        return bookBorrowingRepository.findById(id).orElseThrow(() -> new NotFoundException(Message.NOT_FOUND_MESSAGE));
    }

    @Override
    public Page<BookBorrowing> cursor(int page, int pageSize) {
        return bookBorrowingRepository.findAll(PageRequest.of(page,pageSize));
    }

    @Override
    public boolean delete(long id) {
        bookBorrowingRepository.delete(getId(id));
        return true;
    }
}
