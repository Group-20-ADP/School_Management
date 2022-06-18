package za.ac.cput.school_management.factory;

import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.domain.valueobjects.Address;
import za.ac.cput.school_management.utility.Helper;

/*
Author: Manasseh Barnes
StudentNumber: 218009615
 */

import static za.ac.cput.school_management.utility.Helper.validatePostalCode;

public class AddressFactory {
    public static Address createAddress(String unitNumber, String complexName, String streetNumber, String streetName,
                                        int postalCode, City city) {

        //Validate parameters
        Helper.checkStringParam(unitNumber, "unitNumber");
        Helper.checkStringParam(complexName, "complexName");
        Helper.checkStringParam(streetNumber, "streetNumber");
        Helper.checkStringParam(streetName, "streetName");
        validatePostalCode(String.valueOf(postalCode));
        Helper.checkIfObjectNull("city", city);

        return Address.builder()
                .unitNumber(unitNumber)
                .complexName(complexName)
                .streetNumber(streetNumber)
                .streetName(streetName)
                .postalCode(postalCode)
                .city(city)
                .build();
    }
}
