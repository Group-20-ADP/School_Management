package za.ac.cput.school_management.factory;
/**
 * Author       : Kurtney Clyde Jantjies 218138105
 * Due Created : 18/06/2022
 * Description  : School Management System(Milestone Project)
 */

import za.ac.cput.school_management.domain.valueobjects.Name;
import za.ac.cput.school_management.utility.Helper;

public class NameFactory {
    public static Name createName(String firstName, String middleName, String lastName) {
        Helper.checkStringParam(firstName, "firstName");
        middleName = Helper.setEmptyIfNull(middleName);
        Helper.checkStringParam(lastName, "lastName");

        return Name.builder()
                .firstName(firstName)
                .middleName(middleName)
                .lastName(lastName)
                .build();
    }
}
