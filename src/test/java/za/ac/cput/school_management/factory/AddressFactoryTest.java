package za.ac.cput.school_management.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.domain.valueobjects.Address;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {

    @Test
    void createAddress() {
        Country country = CountryFactory.createCountry("ZA", "South Africa");
        City city = CityFactory.createCity("CPT", "Cape Town", country);
        Address address = AddressFactory.createAddress(
                "1",
                "2",
                "3",
                "4",
                2000,
                city
        );
        assertNotNull(address);
        System.out.println("address = " + address);
    }
}