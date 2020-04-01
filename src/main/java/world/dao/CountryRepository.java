package world.dao;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import world.model.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, String> {
    @Query("SELECT " +
            "c.code, " +
            "c.name, " +
            "c.continent, " +
            "c.region, " +
            "c.surfacearea, " +
            "c.localname, " +
            "c.governmentform, " +
            "c.capital, " +
            "c.code2" +
            " FROM country as c WHERE c.name = :name")
    Iterable<Country> findByName(@Param("name") String name);

    @Query("SELECT " +
            "c.code, " +
            "c.name, " +
            "c.continent, " +
            "c.region, " +
            "c.surfacearea, " +
            "c.localname, " +
            "c.governmentform, " +
            "city.name as 'capitalname', " +
            "c.code2" +
            " FROM country as c LEFT JOIN city on c.capital=city.id")
    Iterable<Country> findAllWithCapitalName();

    @Modifying
    @Query("UPDATE country as c SET c.name = :name WHERE c.id = :id")
    boolean updateName(@Param("name") String name, @Param("id") String id);

    @Modifying
    @Query("UPDATE country as c SET c.surfacearea = :surface WHERE c.id = :id")
    boolean updateSurface(@Param("surface") Double surface, @Param("id") String id);

    @Modifying
    @Query("UPDATE country as c SET c.governmentform = :form WHERE c.id = :id")
    boolean updateGovernmentForm(@Param("form") String name, @Param("id") String id);

    @Modifying
    @Query("UPDATE country as c SET c.capital = :capital WHERE c.id = :id")
    boolean updateCapital(@Param("capital") Integer name, @Param("id") String id);


}
