package world.service;

import world.model.Country;

public interface CountryService extends Service<Country, String> {
    Iterable<Country> findAllWithCapitalName();
}
