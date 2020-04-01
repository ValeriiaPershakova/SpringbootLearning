package world.model;


import world.service.Updatable;

public class CityUpdate implements Updatable {

    private String name;

    private String countrycode;
    private String district;

    private Integer population;


    public CityUpdate() {
    }

    public CityUpdate(String name, String countrycode, String district, Integer population) {
        this.name = name;
        this.countrycode = countrycode;
        this.district = district;
        this.population = population;
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

}
