package mk.ukim.finki.lvemt.config;

import mk.ukim.finki.lvemt.model.enumaration.Category;
import mk.ukim.finki.lvemt.service.AuthorService;
import mk.ukim.finki.lvemt.service.BookService;
import mk.ukim.finki.lvemt.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataHolder {
    private final AuthorService authorService;
    private final BookService bookService;
    private final CountryService countryService;

    public DataHolder(AuthorService authorService, BookService bookService, CountryService countryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.countryService = countryService;
    }

    @PostConstruct
    public void initData(){
        countryService.save("Macedonia", "Europe");
        countryService.save("Russia", "Europe");
        countryService.save("China", "Asia");
        countryService.save("India", "Asia");
        countryService.save("Iceland", "Europe");
        authorService.save("Filip", "Kraljevski", 1L);
        authorService.save("Bojan", "Spasovski", 2L);
        authorService.save("Vladimir", "Damjanovski", 3L);
        authorService.save("Timi", "Trajkovski", 4L);
        authorService.save("Viktor", "Markovski", 5L);
        bookService.save("Exercise", Category.NOVEL, 1L, 4);
        bookService.save("Eat", Category.THRILLER, 2L, 10);
        bookService.save("Read", Category.HISTORY, 3L, 1);
        bookService.save("Meditate", Category.FANTASY, 4L, 5);
        bookService.save("Work", Category.BIOGRAPHY, 5L, 6);
    }
}
