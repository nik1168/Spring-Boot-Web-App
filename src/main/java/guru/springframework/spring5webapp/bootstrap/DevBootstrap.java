package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("On Application event triggered :)");
        initData();
    }

    private void initData(){
        //Jose Madero
        Author jose = new Author("Jose", "Madero");
        Book  pbpm = new Book("Pensandolo bien Pense Mal", "1234", "Movic");
        jose.getBooks().add(pbpm);
        pbpm.getAuthors().add(jose);
        authorRepository.save(jose);
        bookRepository.save(pbpm);

        //Sthepen King
        Author sthepen = new Author("Sthepen", "King");
        Book  drDream = new Book("Dr. Sueno", "12345", "ST");
        sthepen.getBooks().add(drDream);
        drDream.getAuthors().add(sthepen);
        authorRepository.save(sthepen);
        bookRepository.save(drDream);
    }
}
