package world.dao;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import world.model.City;

import java.util.Optional;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {
    @Query("SELECT c.id, c.name, c.countrycode, c.district, c.population FROM city as c WHERE c.name = :name")
    Iterable<City> findByName(@Param("name") String name);

    @Modifying
    @Query("UPDATE city as c SET c.name = :name WHERE c.id = :id")
    boolean updateName(@Param("name") String name, @Param("id") Integer id);

    @Modifying
    @Query("UPDATE city as c SET c.countrycode = :countrycode WHERE c.id = :id")
    boolean updateCountrycode(@Param("countrycode") String countrycode, @Param("id") Integer id);

    @Modifying
    @Query("UPDATE city as c SET c.district = :district WHERE c.id = :id")
    boolean updateDistrict(@Param("district") String district, @Param("id") Integer id);

    @Modifying
    @Query("UPDATE city as c SET c.population = :population WHERE c.id = :id")
    boolean updatePopulation(@Param("population") Integer population, @Param("id") Integer id);

    @Query("SELECT \n" +
            "    city.id,\n" +
            "    city.name,\n" +
            "    city.countrycode,\n" +
            "    c.name as countryname,\n" +
            "    city.district,\n" +
            "    city.population\n" +
            "FROM\n" +
            "    city LEFT JOIN country as c on city.CountryCode=c.code\n" +
            "WHERE\n" +
            "    city.ID = :id;\n")
    Optional<City> findByIdWithCountry(@Param("id") Integer id);
}
