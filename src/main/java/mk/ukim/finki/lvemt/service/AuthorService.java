package mk.ukim.finki.lvemt.service;

import mk.ukim.finki.lvemt.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> listAll();

    Author save(String name, String surname, Long countryId);
}
