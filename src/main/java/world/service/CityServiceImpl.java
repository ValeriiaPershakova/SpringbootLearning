package world.service;

import org.springframework.stereotype.Service;
import world.dao.CityRepository;
import world.exceptions.CityNotFoundException;
import world.model.City;
import world.model.CityUpdate;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository repo;

    public CityServiceImpl(CityRepository cityRepository) {
        this.repo = cityRepository;
    }

    @Override
    public City add(City c) {
        return repo.save(c);
    }

    @Override
    public Iterable<City> findAll() {
        return repo.findAll();
    }

    @Override
    public City findById(Integer id) {
        return repo.findById(id).orElseThrow(() -> new CityNotFoundException(id));
    }

    @Override
    public City findByIdWithCountry(Integer id) {
        return repo.findByIdWithCountry(id).orElseThrow(() -> new CityNotFoundException(id));
    }

    @Override
    public Iterable<City> findByName(String name) {
        Iterable<City> list = repo.findByName(name);
        if (list != null) {
            return repo.findByName(name);
        } else {
            throw new CityNotFoundException();
        }

    }

    @Override
    public boolean existsById(Integer id) {
        return repo.existsById(id);
    }

    @Override
    public long count() {
        return repo.count();
    }

    @Override
    public void update(Integer id, Updatable c) {
        if (repo.existsById(id) && c instanceof CityUpdate) {
            City city = this.findById(id);
            if (((CityUpdate) c).getName() != null && !city.getName().equals(((CityUpdate) c).getName())) {
                repo.updateName(((CityUpdate) c).getName(), id);
            }
            if (((CityUpdate) c).getCountrycode() != null && !city.getCountrycode().equals(((CityUpdate) c).getCountrycode())) {
                repo.updateCountrycode(((CityUpdate) c).getCountrycode(), id);
            }
            if (((CityUpdate) c).getDistrict() != null && !city.getDistrict().equals(((CityUpdate) c).getDistrict())) {
                repo.updateDistrict(((CityUpdate) c).getDistrict(), id);
            }
            if (((CityUpdate) c).getPopulation() != null && !city.getPopulation().equals(((CityUpdate) c).getPopulation())) {
                repo.updatePopulation(((CityUpdate) c).getPopulation(), id);
            }
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new CityNotFoundException(id);
        }
    }
}
