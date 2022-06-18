package za.ac.cput.school_management.factory;

import za.ac.cput.school_management.domain.valueobjects.Address;
import za.ac.cput.school_management.domain.EmployeeAddress;
import za.ac.cput.school_management.utility.Helper;
/*
Author: Manasseh Barnes
StudentNumber: 218009615
 */
public class EmployeeAddressFactory {
    public static EmployeeAddress createEmployeeAddress(String staffId, Address address) {

        Helper.checkStringParam(staffId, "staffId");
        Helper.checkIfObjectNull("address", address);

        return EmployeeAddress.builder()
                .staffId(staffId)
                .address(address)
                .build();
    }
}
