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
import za.ac.cput.school_management.utility.Helper;

public class CityFactory {
    public static City createCity(String cityId, String cityName, Country country) {

        //Validate the parameters
        Helper.checkStringParam(cityId, "cityId");
        Helper.checkStringParam(cityName, "cityName");
        Helper.checkIfObjectNull("country", country);

        return City.builder()
                .id(cityId)
                .name(cityName)
                .country(country)
                .build();
    }
}
