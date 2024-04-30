package art.dborg.library_management.v1.dao;

import art.dborg.library_management.v1.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
