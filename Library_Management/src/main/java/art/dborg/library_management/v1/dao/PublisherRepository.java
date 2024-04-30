package art.dborg.library_management.v1.dao;

import art.dborg.library_management.v1.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {
}
