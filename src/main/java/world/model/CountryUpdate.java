package world.model;

import world.service.Updatable;

import javax.validation.constraints.Positive;

public class CountryUpdate implements Updatable {

    private String name;

    private Continent continent;

    private String region;

    @Positive
    private Double surfacearea;

    private String localname;

    private String governmentform;

    private Integer capital;

    private String code2;


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
}
