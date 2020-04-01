package world.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import world.model.City;
import world.model.CityUpdate;
import world.service.CityService;

import javax.validation.Valid;

@RestController
public class CityController {
    @Autowired
    private CityService service;

    @GetMapping("/city")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<City> showCities() {
        return service.findAll();
    }

    @GetMapping("/city/{id:\\d+}")
    public City findCityById(@PathVariable Integer id) {
        return service.findById(id);
    }


    @PostMapping("/city")
    @ResponseStatus(HttpStatus.CREATED)
    public City addCity(@Valid @RequestBody City n) {
        return service.add(n);

    }

    @DeleteMapping("/city/{id:\\d+}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCity(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @PutMapping("/city/{id:\\d+}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCity(@Valid @RequestBody CityUpdate c, @PathVariable Integer id) {
        service.update(id, c);

    }

    @GetMapping("/city/{id:\\d+}/country")
    public City findCityByIdWithCountry(@PathVariable Integer id) {
        return service.findByIdWithCountry(id);
    }
}
