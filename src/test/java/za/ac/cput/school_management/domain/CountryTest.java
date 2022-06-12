package za.ac.cput.school_management.domain;
/**
 *
 * Humaam Mohamed
 * 214044750
 * Country Test
 *
 */

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test

    public void test(){
        Country country = new Country.CountryBuilder()
                .setId("214044750")
                .setName("Humaam")
                .builder();
        System.out.print(country);
    }

    @AfterAll

    public static void tearDownClass(){

    }

}