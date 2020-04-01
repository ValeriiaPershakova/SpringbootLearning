package world.model;


import deprecated.AddCityForm;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class City {
    @Id
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String countrycode;
    @NotNull
    private String district;
    @NotNull
    @Positive
    private Integer population;

    private String countryname;


    public City() {
    }

    public City(String name, String countrycode, String district, Integer population) {
        this.name = name;
        this.countrycode = countrycode;
        this.district = district;
        this.population = population;
    }

    public City(AddCityForm form) {
        this.name = form.getName();
        this.countrycode = form.getCountrycode();
        this.district = form.getDistrict();
        this.population = form.getPopulation();
    }

    public City(Integer id, String name, String countrycode, String district, Integer population) {
        this.id = id;
        this.name = name;
        this.countrycode = countrycode;
        this.district = district;
        this.population = population;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }
}
