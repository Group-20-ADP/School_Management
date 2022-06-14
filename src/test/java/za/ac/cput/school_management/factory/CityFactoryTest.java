package za.ac.cput.school_management.factory;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.City;

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

        var city = CityFactory.createCity("2587946", "Cape Town");
        assertNotNull (city);
        System.out.println(city);
    }


}

