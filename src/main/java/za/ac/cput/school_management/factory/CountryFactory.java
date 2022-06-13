package za.ac.cput.school_management.factory;
/**
 *
 * Humaam Mohamed
 * 214044750
 * Country Factory
 *
 */

import za.ac.cput.school_management.domain.Country;

public class CountryFactory {

    public static Country createCountry(String id, String name){

        if(id == null)
            return null;

        if(name == null)
            return null;

        return new Country.CountryBuilder()
                .setId(id)
                .setName(name)
                .builder();
    }


}
