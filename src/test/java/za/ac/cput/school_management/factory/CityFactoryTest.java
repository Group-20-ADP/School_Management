package za.ac.cput.school_management.factory;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.Country;

import static org.junit.jupiter.api.Assertions.*;

class CityFactoryTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test

    void createCity() {
        Country country = CountryFactory.createCountry("ZA", "South Africa");

        var city = CityFactory.createCity("CPT", "Cape Town", country);
        assertNotNull (city);
        System.out.println(city);
    }


}

