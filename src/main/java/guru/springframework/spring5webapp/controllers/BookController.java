package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //Spring will detect this as a Spring Beam
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        /*
        Add an attribute to the model called books which will be the list of books coming from
        book repository.
        This is going to tell Spring Data JPA to go out and get a list of books from
        the database and Spring MVC is going to associate that list which is our model
        */
        model.addAttribute("books", bookRepository);
        return "books"; // view name
    }
}
