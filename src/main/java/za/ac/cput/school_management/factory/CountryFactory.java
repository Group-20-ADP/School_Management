package za.ac.cput.school_management.factory;
/**
 *
 * Humaam Mohamed
 * 214044750
 * Country Factory
 *
 */

import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.utility.Helper;

public class CountryFactory {
    public static Country createCountry(String countryId, String countryName) {

        //Validate the parameters
        Helper.checkStringParam(countryId, "countryId");
        Helper.checkStringParam(countryName, "countryName");

        return Country.builder()
                .id(countryId)
                .name(countryName)
                .build();
    }
}
