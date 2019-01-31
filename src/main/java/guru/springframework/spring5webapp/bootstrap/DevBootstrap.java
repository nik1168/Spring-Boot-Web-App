package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;

import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;

import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("On Application event triggered :)");
        initData();
    }

    private void initData(){
        //Jose Madero
        Author jose = new Author("Jose", "Madero");
        Publisher movic = new Publisher("Movic","Monterey Nueva Leon");
        publisherRepository.save(movic);
        Book  pbpm = new Book("Pensandolo bien Pense Mal", "1234", movic);
        jose.getBooks().add(pbpm);
        pbpm.getAuthors().add(jose);
        authorRepository.save(jose);
        bookRepository.save(pbpm);


        //Sthepen King
        Author sthepen = new Author("Sthepen", "King");
        Publisher st = new Publisher("ST","Chicago");
        publisherRepository.save(st);
        Book  drDream = new Book("Dr. Sueno", "12345", st);
        sthepen.getBooks().add(drDream);
        drDream.getAuthors().add(sthepen);
        authorRepository.save(sthepen);
        bookRepository.save(drDream);

    }
}
