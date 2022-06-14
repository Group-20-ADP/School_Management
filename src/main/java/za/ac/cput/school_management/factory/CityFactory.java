package za.ac.cput.school_management.factory;

/**
 *
 * Moegamad Nur Duncan
 * 220014442
 * City Factory
 *
 */

import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.domain.Country;

public class CityFactory {

    public static City createCity(String cityId, String cityName, Country country) {

        if (cityId == null)
            return null;

        if (cityName == null)
            return null;

        if (country == null)
            return null;

        return  City.builder()
                .cityId(cityId)
                .cityName(cityName)
                .country(country)
                .build();



    }

}
