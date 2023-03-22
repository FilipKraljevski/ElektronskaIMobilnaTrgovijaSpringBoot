package mk.ukim.finki.lvemt.service.impl;

import mk.ukim.finki.lvemt.model.Author;
import mk.ukim.finki.lvemt.model.Country;
import mk.ukim.finki.lvemt.repository.AuthorRepository;
import mk.ukim.finki.lvemt.repository.CountryRepository;
import mk.ukim.finki.lvemt.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> listAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author save(String name, String surname, Long countryId) {
        Country country = countryRepository.findById(countryId).orElse(null);
        if(country == null){
            return null;
        }
        Author author = new Author(name, surname, country);
        return authorRepository.save(author);
    }
}
