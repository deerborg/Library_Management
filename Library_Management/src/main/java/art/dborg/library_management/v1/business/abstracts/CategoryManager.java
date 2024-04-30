package art.dborg.library_management.v1.business.abstracts;

import art.dborg.library_management.v1.business.concretes.CategoryServices;
import art.dborg.library_management.v1.core.expection.NotFoundException;
import art.dborg.library_management.v1.core.utilities.Message;
import art.dborg.library_management.v1.dao.CategoryRepository;
import art.dborg.library_management.v1.entities.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryManager implements CategoryServices {
    private final CategoryRepository categoryRepository;
    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        getId(category.getId());
        return categoryRepository.save(category);
    }

    @Override
    public Category getId(long id) {
        return categoryRepository.findById(id).orElseThrow(()-> new NotFoundException(Message.NOT_FOUND_MESSAGE));
    }

    @Override
    public Page<Category> cursor(int page, int pageSize) {
        return categoryRepository.findAll(PageRequest.of(page,pageSize));
    }

    @Override
    public boolean delete(long id) {
        categoryRepository.delete(getId(id));
        return true;
    }
}
