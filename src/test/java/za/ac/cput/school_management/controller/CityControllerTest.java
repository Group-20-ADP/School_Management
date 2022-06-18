package za.ac.cput.school_management.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.factory.CityFactory;
import za.ac.cput.school_management.factory.CountryFactory;
import za.ac.cput.school_management.service.Country.ICountryService;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * Moegamad Nur Duncan
 * 220014442
 * City Controller Tests
 *
 */

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CityControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private CityController cityController;

    private final ICountryService countryService;

    @Autowired
    private TestRestTemplate restTemplate;

    private City city;
    private String baseUrl;

    @Autowired
    CityControllerTest(ICountryService countryService) {
        this.countryService = countryService;
    }

    @BeforeEach
    void setUp() {
        assertNotNull(cityController);
        Country country = CountryFactory.createCountry(
                "USA", "United States of America");
        assertNotNull(country);
        countryService.create(country);
        city = CityFactory.createCity(
                "NYC", "New York", country);
        baseUrl = "http://localhost:" + port + "/city/";
    }

    @Order(1)
    @Test
    void create() {
        String url = baseUrl + "create/";
        System.out.println("url = " + url);
        ResponseEntity<City> response = restTemplate.postForEntity(url, city, City.class);
        System.out.println("response = " + response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Order(3)
    @Test
    void readAll() {
        String url = baseUrl + "getAll/";
        System.out.println("url = " + url);
        ResponseEntity<City[]> response = restTemplate.getForEntity(url, City[].class);
        System.out.println(Arrays.asList(Objects.requireNonNull(response.getBody())));
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Order(2)
    @Test
    void readById() {
        String url = baseUrl + "get/" + city.getId();
        System.out.println("url = " + url);
        ResponseEntity<City> response = restTemplate.getForEntity(url, City.class);
        System.out.println("response = " + response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Order(4)
    @Test
    void findByCountryId() {
        String url = baseUrl + "city-by-country/" + city.getCountry().getId();
        System.out.println("url = " + url);
        ResponseEntity<City[]> response = restTemplate.getForEntity(url, City[].class);
        System.out.println(Arrays.asList(Objects.requireNonNull(response.getBody())));
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Order(5)
    @Test
        //@Disabled
    void delete() {
        String url = baseUrl + "delete/" + city.getId();
        System.out.println("url = " + url);
        restTemplate.delete(url);
    }
}