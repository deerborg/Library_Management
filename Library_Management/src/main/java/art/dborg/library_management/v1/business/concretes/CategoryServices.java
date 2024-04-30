package art.dborg.library_management.v1.business.concretes;

import art.dborg.library_management.v1.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryServices {
    Category save(Category category);
    Category update(Category category);
    Category getId(long id);
    Page<Category> cursor(int page, int pageSize);
    boolean delete(long id);
}
