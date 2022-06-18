package za.ac.cput.school_management.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.domain.StudentAddress;
import za.ac.cput.school_management.domain.valueobjects.Address;
import za.ac.cput.school_management.factory.AddressFactory;
import za.ac.cput.school_management.factory.CityFactory;
import za.ac.cput.school_management.factory.CountryFactory;
import za.ac.cput.school_management.factory.StudentAddressFactory;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentAddressControllerTest {

    @Autowired
    private StudentAddressController controller;
    @Autowired private TestRestTemplate restTemplate;

    private String baseUrl = "http://localhost:8080/studentaddress";
    private static Country country;
    private static City city;
    private static Address address;
    private static StudentAddress studentAddress;

    @Order(0)
    @Test
    void init() {
        country = CountryFactory.createCountry("447", "Zambia");
        city = CityFactory.createCity("OPO","OPPOTUNITY",country);
        address = AddressFactory.createAddress("POOP", "MKP","JKS", "GGX",7485, city);
        assertNotNull(controller);
        assertNotNull(country);
        assertNotNull(city);
        assertNotNull(address);
        System.out.println(country);
        System.out.println(city);
        System.out.println(address);
        studentAddress = StudentAddressFactory.createStudentAddress("Y2K", address);
        System.out.println(studentAddress);
        assertNotNull(studentAddress);
    }

    @Order(1)
    @Test
    void save(){
        System.out.println(baseUrl);
        String url = baseUrl + "/create";
        System.out.println(url);
        ResponseEntity<StudentAddress> response = this.restTemplate
                .postForEntity(url, studentAddress, StudentAddress.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(2)
    @Test
    void read(){
        String url = baseUrl + "/read/" + studentAddress.getStudentId();
        System.out.println(url);
        ResponseEntity<StudentAddress> response =
                this.restTemplate.getForEntity(url, StudentAddress.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Order(4)
    @Test
    void delete(){
        String url = baseUrl + "/delete";
        System.out.println(url);
        ResponseEntity<StudentAddress> response = this.restTemplate
                .postForEntity(url, studentAddress, StudentAddress.class);
        this.restTemplate.delete(url);
    }

    @Order(3)
    @Test
    void getAll(){
        String url = baseUrl + "/getall";
        System.out.println(url);
        ResponseEntity<StudentAddress[]> response =
                this.restTemplate.getForEntity(url, StudentAddress[].class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(1, Objects.requireNonNull(response.getBody()).length)
        );
    }

}
