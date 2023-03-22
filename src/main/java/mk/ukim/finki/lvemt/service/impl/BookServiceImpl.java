package mk.ukim.finki.lvemt.service.impl;

import mk.ukim.finki.lvemt.model.Author;
import mk.ukim.finki.lvemt.model.Book;
import mk.ukim.finki.lvemt.model.enumaration.Category;
import mk.ukim.finki.lvemt.repository.AuthorRepository;
import mk.ukim.finki.lvemt.repository.BookRepository;
import mk.ukim.finki.lvemt.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if(book == null){
            return null;
        }
        return book;
    }

    @Override
    public Book save(String name, Category category, Long authorId, Integer availableCopies) {
        Author author = authorRepository.findById(authorId).orElse(null);
        if(author == null){
            return null;
        }
        if(availableCopies < 0){
            availableCopies = 0;
        }
        Book book = new Book(name, category, author, availableCopies);
        return bookRepository.save(book);
    }

    @Override
    public Book update(Long bookId, String name, Category category, Long authorId, Integer availableCopies) {
        Book book = findById(bookId);
        Author author = authorRepository.findById(authorId).orElse(null);
        if(author == null || book == null){
            return null;
        }
        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author);
        if(availableCopies < 0){
            availableCopies = 0;
        }
        book.setAvailableCopies(availableCopies);
        return bookRepository.save(book);
    }

    @Override
    public Book delete(Long id) {
        Book book = findById(id);
        bookRepository.delete(book);
        return book;
    }

    @Override
    public Book markAsTaken(Long id) {
        Book book = findById(id);
        if(book.getAvailableCopies() == 0){
            return null;
        }
        book.setAvailableCopies(book.getAvailableCopies()-1);
        bookRepository.save(book);
        return book;
    }
}
