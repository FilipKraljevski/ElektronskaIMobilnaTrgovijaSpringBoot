package mk.ukim.finki.lvemt.service;

import mk.ukim.finki.lvemt.model.Book;
import mk.ukim.finki.lvemt.model.enumaration.Category;

import java.util.List;

public interface BookService {
    List<Book> listAll();

    Book findById(Long id);

    Book save(String name, Category category, Long authorId, Integer availableCopies);

    Book update(Long bookId, String name, Category category, Long authorId, Integer availableCopies);

    Book delete(Long id);

    Book markAsTaken(Long id);
}
