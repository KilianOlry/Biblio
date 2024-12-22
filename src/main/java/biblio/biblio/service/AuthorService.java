package biblio.biblio.service;

import biblio.biblio.entities.Author;
import biblio.biblio.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> selectAll() {
        return (List<Author>) authorRepository.findAll();
    }

    public Author selectById(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        return author.orElse(null);
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }
}
