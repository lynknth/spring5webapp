package Guru.springframework.spring5webapp.bootstrap;

import Guru.springframework.spring5webapp.domain.Author;
import Guru.springframework.spring5webapp.domain.Book;
import Guru.springframework.spring5webapp.domain.Publisher;
import Guru.springframework.spring5webapp.repositories.AuthorRepository;
import Guru.springframework.spring5webapp.repositories.BookRepository;
import Guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Stated in Bootstrap");

        Publisher publisher1= new Publisher();
        publisher1.setName("Otava");
        publisher1.setAddress("11 AlexinKata");
        publisher1.setCity("Helsinki");
        publisher1.setState("Helsinki");
        publisher1.setZip("00704");

        publisherRepository.save(publisher1);
        System.out.println("Number of publisher: " +publisherRepository.count());

        Author author1 = new Author("Aino","Havukainen");
        Book book1 = new Book("This is FinLand","121212");
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        book1.setPublisher(publisher1);
        publisher1.getBooks().add(book1);

        authorRepository.save(author1);
        bookRepository.save(book1);
        publisherRepository.save(publisher1);


        Author author2 = new Author("Raymon", "Murphy");
        Book book2 = new Book("English grammar in use","23456");
        author1.getBooks().add(book2);
        book2.getAuthors().add(author2);
        book2.setPublisher(publisher1);
        publisher1.getBooks().add(book2);

        authorRepository.save(author2);
        bookRepository.save(book2);
        publisherRepository.save(publisher1);

        System.out.println("Number of book: " + bookRepository.count());
        System.out.println("Publisher number of book: "+ publisher1.getBooks().size());


    }
}
