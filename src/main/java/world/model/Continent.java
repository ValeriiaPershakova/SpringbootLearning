package world.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum Continent {
    ASIA,
    EUROPE,
    @JsonProperty("North America") NORTH_AMERICA,
    AFRICA,
    OCEANIA,
    ANTARCTICA,
    @JsonProperty("South America") SOUTH_AMERICA;

    private static Map<String, Continent> namesMap = new HashMap<>();

    static {
        namesMap.put("Asia", ASIA);
        namesMap.put("Europe", EUROPE);
        namesMap.put("North America", NORTH_AMERICA);
        namesMap.put("Africa", AFRICA);
        namesMap.put("Oceania", OCEANIA);
        namesMap.put("Antarctica", ANTARCTICA);
        namesMap.put("South America", SOUTH_AMERICA);
    }


    @JsonCreator
    public static Continent forValue(String value) {
        return namesMap.get(value);
    }

    public static Map<String, Continent> getNamesMap() {
        return namesMap;
    }

    public static void setNamesMap(Map<String, Continent> namesMap) {
        Continent.namesMap = namesMap;
    }

    @JsonValue
    public String toValue() {
        for (Map.Entry<String, Continent> entry : namesMap.entrySet()) {
            if (entry.getValue() == this)
                return entry.getKey();
        }

        return null;
    }
}
