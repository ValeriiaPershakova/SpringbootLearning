package world.service;

import org.springframework.stereotype.Service;
import world.dao.CountryRepository;
import world.exceptions.CountryNotFoundException;
import world.model.Country;
import world.model.CountryUpdate;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository repo;

    public CountryServiceImpl(CountryRepository repo) {
        this.repo = repo;
    }

    @Override
    public Country add(Country c) {
        return repo.save(c);
    }

    @Override
    public Iterable<Country> findAll() {
        return repo.findAll();
    }

    @Override
    public Iterable<Country> findAllWithCapitalName() {
        return repo.findAllWithCapitalName();
    }

    @Override
    public Country findById(String id) {
        return repo.findById(id).orElseThrow(() -> new CountryNotFoundException(id));
    }

    @Override
    public Iterable<Country> findByName(String name) {
        Iterable<Country> list = repo.findByName(name);
        if (list != null) {
            return repo.findByName(name);
        } else {
            throw new CountryNotFoundException();
        }
    }

    @Override
    public boolean existsById(String id) {
        return repo.existsById(id);
    }

    @Override
    public long count() {
        return repo.count();
    }

    @Override
    public void update(String id, Updatable c) {
        if (repo.existsById(id) && c instanceof CountryUpdate) {
            Country country = this.findById(id);
            if (((CountryUpdate) c).getName() != null && !country.getName().equals(((CountryUpdate) c).getName())) {
                repo.updateName(((CountryUpdate) c).getName(), id);
            }
            if (((CountryUpdate) c).getSurfacearea() != null && !country.getSurfacearea().equals(((CountryUpdate) c).getSurfacearea())) {
                repo.updateSurface(((CountryUpdate) c).getSurfacearea(), id);
            }
            if (((CountryUpdate) c).getGovernmentform() != null && !country.getGovernmentform().equals(((CountryUpdate) c).getGovernmentform())) {
                repo.updateGovernmentForm(((CountryUpdate) c).getGovernmentform(), id);
            }
            if (((CountryUpdate) c).getCapital() != null && !country.getCapital().equals(((CountryUpdate) c).getCapital())) {
                repo.updateCapital(((CountryUpdate) c).getCapital(), id);
            }
        }
    }

    @Override
    public void deleteById(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new CountryNotFoundException(id);
        }
    }
}
