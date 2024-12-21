package biblio.biblio.controller;

import biblio.biblio.entities.Author;
import biblio.biblio.entities.Book;
import biblio.biblio.repository.BookRepository;
import biblio.biblio.service.AuthorService;
import biblio.biblio.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    // SELECT ALL BOOKS
    @GetMapping(path = "livres")
    public String books(Model model) {
        List<Book> books = bookService.selectAll();
        model.addAttribute("books", books);
        return "books/books";
    }

    // DETAILS OF BOOK
    @GetMapping(path = "livre/{id}")
    public String book(@PathVariable Long id, Model model) {
        Book book = bookService.selectById(id);
        if (book != null) {
            model.addAttribute("book", bookService.selectById(id));
            return "books/book";
        }
        return "redirect:/livres";
    }

    // CREATE BOOK
    @GetMapping(path = "livre/ajouter")
    public String showPage(Model model) {
        model.addAttribute("action", "create");
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.selectAll());
        return "books/form";
    }

    @PostMapping(path = "livre/ajouter")
    public ModelAndView create (@ModelAttribute Book book) {
        bookService.save(book);
        return new ModelAndView("redirect:/livres");
    }

    // UPDATE BOOK
    @GetMapping(path = "livre/modifier/{id}")
    public String modifier(@PathVariable Long id, Model model) {
        Book book = bookService.selectById(id);
        if (book != null) {
            model.addAttribute("book", bookService.selectById(id));
            return "books/form";
        }
        return "redirect:/livres";
    }

    @PostMapping(path = "livre/modifier/{id}")
    public ModelAndView modifier(@ModelAttribute Book book, @PathVariable Long id) {
        if(bookService.selectById(id) != null) {
            book.setId(id);
            bookRepository.save(book);
        }
        return new ModelAndView("redirect:/livres");
    }

    // DELETE BOOK
    @PostMapping(path = "/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/livres";
    }
}
