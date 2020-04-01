package world.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class Country {
    @Id
    @NotNull
    private String code;
    @NotNull
    private String name;
    @NotNull
    private Continent continent;
    @NotNull
    private String region;
    @NotNull
    @Positive
    private Double surfacearea;
    @NotNull
    private String localname;
    @NotNull
    private String governmentform;
    @NotNull
    private Integer capital;
    @NotNull
    private String code2;

    private String capitalname;

    private Iterable<City> cities;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapital() {
        return capital;
    }

    public void setCapital(Integer capital) {
        this.capital = capital;
    }

    public Iterable<City> getCities() {
        return cities;
    }

    public void setCities(Iterable<City> cities) {
        this.cities = cities;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getSurfacearea() {
        return surfacearea;
    }

    public void setSurfacearea(Double surfacearea) {
        this.surfacearea = surfacearea;
    }

    public String getLocalname() {
        return localname;
    }

    public void setLocalname(String localname) {
        this.localname = localname;
    }

    public String getGovernmentform() {
        return governmentform;
    }

    public void setGovernmentform(String governmentform) {
        this.governmentform = governmentform;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public String getCapitalname() {
        return capitalname;
    }

    public void setCapitalname(String capitalname) {
        this.capitalname = capitalname;
    }
}
