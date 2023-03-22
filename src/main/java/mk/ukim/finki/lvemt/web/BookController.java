package mk.ukim.finki.lvemt.web;

import mk.ukim.finki.lvemt.model.Book;
import mk.ukim.finki.lvemt.model.enumaration.Category;
import mk.ukim.finki.lvemt.service.AuthorService;
import mk.ukim.finki.lvemt.service.BookService;
import mk.ukim.finki.lvemt.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"/", "/books"})
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;
    public final CountryService countryService;

    public BookController(BookService bookService, AuthorService authorService, CountryService countryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
    }

    @GetMapping
    public String getBooksPage(Model model){
        model.addAttribute("books", bookService.listAll());
        return "listBooks";
    }

    @GetMapping("/addBook")
    public String getAddPage(Model model){
        model.addAttribute("authors", authorService.listAll());
        model.addAttribute("categories", Category.values());
        return "addBook";
    }

    @PostMapping("/add")
    public String saveBook(@RequestParam String name, @RequestParam Category category, @RequestParam Long authorId,
                           @RequestParam Integer availableCopies){
        bookService.save(name, category, authorId, availableCopies);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable Long id, Model model){
        Book book = bookService.findById(id);
        if(book == null){
            return "redirect:/books";
        }
        model.addAttribute("book", book);
        model.addAttribute("authors", authorService.listAll());
        model.addAttribute("categories", Category.values());
        return "addBook";
    }

    @PostMapping("/add/{id}")
    public String updateBook(@PathVariable Long id, @RequestParam String name, @RequestParam Category category,
                             @RequestParam Long authorId, @RequestParam Integer availableCopies){
        bookService.update(id, name, category, authorId, availableCopies);
        return "redirect:/books";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.delete(id);
        return "redirect:/books";
    }

    @PostMapping("/{id}")
    public String markAsTaken(@PathVariable Long id){
        bookService.markAsTaken(id);
        return "redirect:/books";
    }
}
