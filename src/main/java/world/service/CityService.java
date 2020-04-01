package world.service;

import world.model.City;

public interface CityService extends Service<City, Integer> {
    City findByIdWithCountry(Integer id);


}
