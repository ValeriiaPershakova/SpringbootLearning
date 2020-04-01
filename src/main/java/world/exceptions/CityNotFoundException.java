package world.exceptions;

import static java.lang.String.format;

public class CityNotFoundException extends RuntimeException {
    private Integer cityId = null;

    public CityNotFoundException() {
    }

    public CityNotFoundException(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public String getMessage() {
        if (cityId != null) {
            return format("City with id = %s not found", cityId);
        } else {
            return "City not found";
        }

    }
}
