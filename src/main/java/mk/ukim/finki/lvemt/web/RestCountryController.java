package mk.ukim.finki.lvemt.web;

import mk.ukim.finki.lvemt.model.Country;
import mk.ukim.finki.lvemt.service.CountryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/countries")
public class RestCountryController {
    private final CountryService countryService;

    public RestCountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> listCountries(){
        return countryService.listAll();
    }
}
