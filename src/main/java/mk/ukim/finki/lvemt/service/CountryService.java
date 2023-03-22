package mk.ukim.finki.lvemt.service;

import mk.ukim.finki.lvemt.model.Country;

public interface CountryService {
    Country save(String name, String continent);
}
