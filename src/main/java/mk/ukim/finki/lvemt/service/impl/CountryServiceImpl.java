package mk.ukim.finki.lvemt.service.impl;

import mk.ukim.finki.lvemt.model.Country;
import mk.ukim.finki.lvemt.repository.CountryRepository;
import mk.ukim.finki.lvemt.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> listAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country save(String name, String continent) {
        Country country = new Country(name, continent);
        return countryRepository.save(country);
    }
}
