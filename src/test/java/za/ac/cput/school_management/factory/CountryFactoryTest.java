package za.ac.cput.school_management.factory;
/**
 *
 * Humaam Mohamed
 * 214044750
 * Country Factory Test
 *
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.Country;
import static org.junit.jupiter.api.Assertions.*;

class CountryFactoryTest {


    @Test
    void createCountry() {
        Country country = CountryFactory.createCountry("ZA", "South Africa");
        assertNotNull(country);
    }

    @Test
    void createCountryWithEmptyId() {
        Country country = CountryFactory.createCountry("", "South Africa");
        assertEquals("", country.getId());
    }

    @Test
    void createCountryWithNullName() {
        Country country = CountryFactory.createCountry("ZA", null);
        assertNotNull(country);
    }
}