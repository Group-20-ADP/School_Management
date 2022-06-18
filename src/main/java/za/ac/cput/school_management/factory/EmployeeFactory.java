package za.ac.cput.school_management.factory;
/**
 * Author       : Kurtney Clyde Jantjies 218138105
 * Due Created : 18/06/2022
 * Description  : School Management System(Milestone Project)
 */

import za.ac.cput.school_management.domain.Employee;
import za.ac.cput.school_management.domain.valueobjects.Name;
import za.ac.cput.school_management.utility.Helper;

public class EmployeeFactory {
    public static Employee createEmployee(String staffId, String email,
                                          String firstName, String middleName,
                                          String lastName){

        Helper.checkStringParam(staffId, "staffId");
        Helper.checkStringParam(email, "email");
        Helper.checkEmail(email);
        Helper.checkStringParam(firstName, "firstName");
        Helper.checkStringParam(middleName, "middleName");
        Helper.checkStringParam(lastName, "lastName");

        Name name = NameFactory.createName(firstName,middleName,lastName);
        return Employee.builder()
                .staffId(staffId)
                .email(email)
                .name(name)
                .build();
    }
}
