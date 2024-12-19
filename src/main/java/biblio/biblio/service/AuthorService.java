package biblio.biblio.service;

import biblio.biblio.entities.Author;
import biblio.biblio.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> selectAll() {
        return (List<Author>) authorRepository.findAll();
    }

}
