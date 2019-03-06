package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        /*
        Add an attribute to the model called books which will be the list of books coming from
        book repository.
        This is going to tell Spring Data JPA to go out and get a list of books from
        the database and Spring MVC is going to associate that list which is our model
        */
        model.addAttribute("authors", authorRepository.findAll()); // return an iterable
        return "authors"; // view name
    }
}
