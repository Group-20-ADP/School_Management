package za.ac.cput.school_management.controller;

/**
 *
 * Humaam Mohamed
 * 214044750
 * Country Controller Test
 *
 */

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.factory.CountryFactory;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CountryControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private CountryController countryController;

    @Autowired private TestRestTemplate restTemplate;

    private String baseUrl;

    private Country country;

    @BeforeEach
    void setUp() {
        assertNotNull(countryController);
        country = CountryFactory.createCountry("USA", "United States of America");
        baseUrl = "http://localhost:" + port + "/country/";
    }

    @Order(1)
    @Test
    void create() {
        String url = baseUrl + "create/";
        System.out.println("url = " + url);
        ResponseEntity<Country> response = restTemplate.postForEntity(url, country, Country.class);
        System.out.println("response = " + response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Order(4)
    @Test
    void readAll() {
        String url = baseUrl + "getAll/";
        System.out.println("url = " + url);
        ResponseEntity<Country[]> response = restTemplate.getForEntity(url, Country[].class);
        System.out.println(Arrays.asList(Objects.requireNonNull(response.getBody())));
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Order(2)
    @Test
    void readById() {
        String url = baseUrl + "get/" + country.getId();
        System.out.println("url = " + url);
        ResponseEntity<Country> response = restTemplate.getForEntity(url, Country.class);
        System.out.println("response = " + response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Order(3)
    @Test
        //@Disabled
    void delete() {
        String url = baseUrl + "delete/" + country.getId();
        System.out.println("url = " + url);
        restTemplate.delete(url);
    }
}