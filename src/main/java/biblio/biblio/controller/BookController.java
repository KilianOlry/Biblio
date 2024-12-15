package biblio.biblio.controller;

import biblio.biblio.entities.Book;
import biblio.biblio.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(path = "livres")
    public String books(Model model) {
        List<Book> books = (List<Book>) bookRepository.findAll();
        model.addAttribute("books", books);
        return "books/books";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/livres";
    }
}
