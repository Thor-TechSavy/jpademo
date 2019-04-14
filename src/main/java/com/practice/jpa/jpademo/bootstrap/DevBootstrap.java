package com.practice.jpa.jpademo.bootstrap;

import com.practice.jpa.jpademo.model.Author;
import com.practice.jpa.jpademo.model.Book;
import com.practice.jpa.jpademo.model.Publisher;
import com.practice.jpa.jpademo.repositories.AuthorRepository;
import com.practice.jpa.jpademo.repositories.BookRepository;
import com.practice.jpa.jpademo.repositories.PublisherRepository;
import org.apache.catalina.core.AprLifecycleListener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * created by  techSavyThor on 3/31/2019
 */
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
        initData();
    }

    private void initData() {
        Publisher publisher=new Publisher();
        publisher.setName("foo");
        publisherRepository.save(publisher);

        Publisher publisher1=new Publisher();
        publisher1.setName("Thor");
        publisherRepository.save(publisher1);
        //Eric
        Author eric = new Author("Eric","Evans");
        Book ddd=new Book("Domain driver Design" ,"1234" ,publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod","Johnson");
        Book noEJB=new Book("J2EE development without EJB" ,"23444",publisher1);
        rod.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
