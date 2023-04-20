package mk.ukim.finki.lvemt.service;

import mk.ukim.finki.lvemt.model.Book;
import mk.ukim.finki.lvemt.model.dto.BookDto;
import mk.ukim.finki.lvemt.model.enumaration.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listAll();

    Optional<Book> findById(Long id);

    Book save(String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> update(Long id, BookDto bookDto);

    Optional<Book> delete(Long id);

    Optional<Book> markAsTaken(Long id);
}
