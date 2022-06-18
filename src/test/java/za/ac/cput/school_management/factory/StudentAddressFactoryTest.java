package za.ac.cput.school_management.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.domain.StudentAddress;
import za.ac.cput.school_management.domain.valueobjects.Address;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentAddressFactoryTest {

    private static Country country = CountryFactory.createCountry("221", "IRAQ");
    private static City city = CityFactory.createCity("231", "Durban", country);
    private static Address address = AddressFactory.createAddress("XxX", "ADRR", "11", "Long", 1551, city);

    @Test
    void createStudentAddressPass() {
        StudentAddress x = StudentAddressFactory.createStudentAddress("331", address);
        assertNotNull(x);
        System.out.println(x.toString());
    }

    @Test
    void createStudentAddressFail() {
        assertThrows(IllegalArgumentException.class, () -> {
            StudentAddressFactory.createStudentAddress(" ", address);
        });
        System.out.println("Thrown an error as expected");
    }
}

