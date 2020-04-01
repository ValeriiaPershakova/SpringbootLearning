package world.exceptions;

public class CountryNotFoundException extends RuntimeException {
    private String countryId = null;

    public CountryNotFoundException() {
    }

    public CountryNotFoundException(String countryId) {
        this.countryId = countryId;
    }

    @Override
    public String getMessage() {
        if (countryId != null) {
            return String.format("Country with id = %s not found", countryId);
        } else {
            return "Country not found";
        }
    }
}
