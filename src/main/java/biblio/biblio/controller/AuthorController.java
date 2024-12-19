package biblio.biblio.controller;

import biblio.biblio.entities.Author;
import biblio.biblio.repository.AuthorRepository;
import biblio.biblio.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorService authorService;

    @GetMapping(path = "/auteurs")
    private String auteurs(Model model) {
        List<Author> authors = authorService.selectAll();
        model.addAttribute("authors", authors);
        return "authors/authors";
    }
}
