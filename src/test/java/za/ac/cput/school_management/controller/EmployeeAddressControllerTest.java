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
import za.ac.cput.school_management.domain.Employee;
import za.ac.cput.school_management.domain.EmployeeAddress;
import za.ac.cput.school_management.domain.valueobjects.Address;
import za.ac.cput.school_management.domain.valueobjects.Name;
import za.ac.cput.school_management.factory.*;
import za.ac.cput.school_management.service.City.ICityService;
import za.ac.cput.school_management.service.Country.ICountryService;
import za.ac.cput.school_management.service.Employee.IEmployeeService;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeAddressControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private EmployeeAddressController employeeAddressController;

    private final ICityService cityService;
    private final ICountryService countryService;
    private final IEmployeeService employeeService;

    @Autowired
    private TestRestTemplate restTemplate;
    private EmployeeAddress employeeAddress;
    private String baseUrl;

    @Autowired
    EmployeeAddressControllerTest(ICityService cityService, ICountryService countryService, IEmployeeService employeeService) {
        this.cityService = cityService;
        this.countryService = countryService;
        this.employeeService = employeeService;
    }

    @BeforeEach
    void setUp() {
        assertNotNull(employeeAddressController);
        //Create objects to be used in the test
        Country country = CountryFactory.createCountry("ZA", "South Africa");
        City city = CityFactory.createCity("CPT", "Cape Town", country);
        Address address = AddressFactory.createAddress(
                "1",
                "Test",
                "1",
                "Test",
                2000,
                city
        );
        Name name = NameFactory.createName("Manny", "Barney", "Barnes");
        Employee employee = EmployeeFactory.createEmployee("12345", "Valid@email.com", name);

        //Check if objects are created
        assertNotNull(country);
        assertNotNull(city);
        assertNotNull(address);
        assertNotNull(name);
        assertNotNull(employee);

        //Prepare the EmployeeAddress
        countryService.create(country);
        cityService.create(city);
        employeeService.create(employee);

        //Create EmployeeAddress
        employeeAddress = EmployeeAddressFactory.createEmployeeAddress(
                employee.getStaffId(), address
        );
        baseUrl = "http://localhost:" + port + "/employee-address/";
    }

    @Order(1)
    @Test
    void create() {
        String url = baseUrl + "create/";
        System.out.println("url = " + url);
        ResponseEntity<EmployeeAddress> response = restTemplate.postForEntity(url, employeeAddress, EmployeeAddress.class);
        System.out.println("response = " + response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Order(4)
    @Test
    void readAll() {
        String url = baseUrl + "getAll/";
        System.out.println("url = " + url);
        ResponseEntity<EmployeeAddress[]> response = restTemplate.getForEntity(url, EmployeeAddress[].class);
        System.out.println(Arrays.asList(Objects.requireNonNull(response.getBody())));
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Order(2)
    @Test
    void readById() {
        String url = baseUrl + "get/" + employeeAddress.getStaffId();
        System.out.println("url = " + url);
        ResponseEntity<EmployeeAddress> response = restTemplate.getForEntity(url, EmployeeAddress.class);
        System.out.println("response = " + response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Order(3)
    @Test
    void delete() {
        String url = baseUrl + "delete/" + employeeAddress.getStaffId();
        System.out.println("url = " + url);
        restTemplate.delete(url);
    }
}