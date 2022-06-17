package za.ac.cput.school_management.factory;

/**
 *
 * Moegamad Nur Duncan
 * 220014442
 * City Factory
 *
 */

import za.ac.cput.school_management.domain.City;

public class CityFactory {

    public static City createCity(String cityId, String cityName) {

        if (cityId == null)
            return null;

        if (cityName == null)
            return null;



        return  City.builder()
                .cityId(cityId)
                .cityName(cityName)
                .build();



    }

}
