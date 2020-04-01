package world.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import world.model.Country;
import world.model.CountryUpdate;
import world.service.CountryService;

import javax.validation.Valid;

@RestController
public class CountryController {
    @Autowired
    private CountryService service;

    @GetMapping("/country")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Country> showCountries() {
        return service.findAllWithCapitalName();
    }

    @GetMapping("/country/{id}")
    public Country findCountryById(@PathVariable String id) {
        return service.findById(id);
    }


    @PostMapping("/country")
    @ResponseStatus(HttpStatus.CREATED)
    public Country addCountry(@Valid @RequestBody Country n) {
        return service.add(n);

    }

    @DeleteMapping("/country/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCountry(@PathVariable String id) {
        service.deleteById(id);
    }

    @PutMapping("/country/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCountry(@Valid @RequestBody CountryUpdate c, @PathVariable String id) {
        service.update(id, c);

    }

//    @GetMapping("/country/{id:\\d+}/country")
//    public City findCityByIdWithCountry(@PathVariable Integer id) {
//        return service.findByIdWithCountry(id);
//    }
}
