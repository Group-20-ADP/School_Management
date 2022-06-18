package za.ac.cput.school_management.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.domain.EmployeeAddress;
import za.ac.cput.school_management.domain.valueobjects.Address;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeAddressFactoryTest {

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
        EmployeeAddress employeeAddress = EmployeeAddressFactory.createEmployeeAddress(
                "1",
                null
        );
        assertNull(employeeAddress);
    }

    @Test
    void createEmployeeAddressWithEmpty() {
        EmployeeAddress employeeAddress = EmployeeAddressFactory.createEmployeeAddress(
                "",
                null
        );
        assertNull(employeeAddress);
    }
}