package biblio.biblio.service;

import biblio.biblio.entities.Author;
import biblio.biblio.entities.Book;
import biblio.biblio.repository.AuthorRepository;
import biblio.biblio.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> selectAll() {
        return (List<Book>) bookRepository.findAll();
    }

    public Book selectById(long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book addBookWithAuthor(Book book, long authorId) {
        Optional<Author> author = authorRepository.findById(authorId);
        if (author != null) {
            book.setAuthor(author.get());
            return bookRepository.save(book);
        }
        return null;
    }
}
