package art.dborg.library_management.v1.business.concretes;

import art.dborg.library_management.v1.entities.BookBorrowing;
import art.dborg.library_management.v1.entities.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherServices {
    Publisher save(Publisher publisher);
    Publisher update(Publisher publisher);
    Publisher getId(long id);
    Page<Publisher> cursor(int page, int pageSize);
    boolean delete(long id);
}
