package mk.ukim.finki.lvemt.service;

import mk.ukim.finki.lvemt.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> listAll();

    Country save(String name, String continent);
}
