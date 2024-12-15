package biblio.biblio.controller;

import biblio.biblio.entities.Book;
import biblio.biblio.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // SELECT ALL BOOKS
    @GetMapping(path = "livres")
    public String books(Model model) {
        List<Book> books = (List<Book>) bookRepository.findAll();
        model.addAttribute("books", books);
        return "books/books";
    }

    // DETAILS OF BOOK
    @GetMapping(path = "livre/{id}")
    public String book(@PathVariable Long id, Model model) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            model.addAttribute("book", optionalBook.get());
        } else {
            return "redirect:/livres";
        }
        return "books/book";
    }

    // CREATE BOOK


    // UPDATE BOOK


    // DELETE BOOK
    @GetMapping(path = "/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/livres";
    }
}
