package za.ac.cput.school_management.factory;
/**
 *
 * Humaam Mohamed
 * 214044750
 * Country Factory Test
 *
 */
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.Country;

import static org.junit.jupiter.api.Assertions.*;

class CountryFactoryTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test

    public void test(){
        Country country = CountryFactory.createCountry("214044750","Humaam");
        assertNotNull(country);
    }
}