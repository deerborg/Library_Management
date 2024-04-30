package art.dborg.library_management.v1.business.abstracts;

import art.dborg.library_management.v1.business.concretes.AuthorServices;
import art.dborg.library_management.v1.core.expection.NotFoundException;
import art.dborg.library_management.v1.core.utilities.Message;
import art.dborg.library_management.v1.dao.AuthorRepository;
import art.dborg.library_management.v1.entities.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorManager implements AuthorServices {
    private final AuthorRepository authorRepository;
    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author update(Author author) {
        getId(author.getId());
        return authorRepository.save(author);
    }

    @Override
    public Author getId(long id) {
        return authorRepository.findById(id).orElseThrow(() -> new NotFoundException(Message.NOT_FOUND_MESSAGE));
    }

    @Override
    public Page<Author> cursor(int page, int pageSize) {
        return authorRepository.findAll(PageRequest.of(page,pageSize));
    }

    @Override
    public boolean delete(long id) {
        authorRepository.delete(getId(id));
        return true;
    }
}
