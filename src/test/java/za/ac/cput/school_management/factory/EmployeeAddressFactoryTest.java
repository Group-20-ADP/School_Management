package za.ac.cput.school_management.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.domain.EmployeeAddress;
import za.ac.cput.school_management.domain.valueobjects.Address;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeAddressFactoryTest {
    /*
    Author: Manasseh Barnes
    StudentNumber: 218009615
     */
    @Test
    void createEmployeeAddress() {
        Country country = CountryFactory.createCountry("ZA", "South Africa");
        City city = CityFactory.createCity("Cape Town", "South Africa", country);
        Address address = AddressFactory.createAddress("1", "Test","",
                "Test", 2000, city);
        EmployeeAddress employeeAddress = EmployeeAddressFactory.createEmployeeAddress(
                "1",
                address
        );
        assertNotNull(employeeAddress);
        System.out.println("employeeAddress = " + employeeAddress);
    }

    @Test
    void createEmployeeAddressWithNull() {
        //Throw IllegalArgumentException if address is null
        assertThrows(IllegalArgumentException.class, () -> {
            EmployeeAddressFactory.createEmployeeAddress(
                    "1",
                    null
            );
        });
    }

    @Test
    void createEmployeeAddressWithEmpty() {
        //Throw IllegalArgumentException if address is empty
        assertThrows(IllegalArgumentException.class, () -> {
            EmployeeAddressFactory.createEmployeeAddress(
                    "1",
                    AddressFactory.createAddress("", "",
                            "", "", 2000, null)
            );
        });
    }
}