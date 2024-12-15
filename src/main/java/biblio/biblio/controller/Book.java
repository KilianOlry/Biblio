package biblio.biblio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Book {

    @GetMapping(path = "livres")
    public String books() {
        return "books/books";
    }
}
