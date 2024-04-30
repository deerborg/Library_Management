package art.dborg.library_management.v1.dao;

import art.dborg.library_management.v1.entities.BookBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookBorrowingRepository extends JpaRepository<BookBorrowing,Long> {
}
