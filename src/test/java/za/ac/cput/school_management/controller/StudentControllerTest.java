package za.ac.cput.school_management.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.domain.Student;
import za.ac.cput.school_management.domain.valueobjects.Name;
import za.ac.cput.school_management.factory.CountryFactory;
import za.ac.cput.school_management.factory.StudentFactory;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StudentControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private StudentController studentController;
    @Autowired
    private TestRestTemplate restTemplate;

    private String baseUrl;

    private Student student;

    @BeforeEach
    void setUp() {
        assertNotNull(studentController);
        student = StudentFactory.createStudent("2121", "athi@gmail.com", Name.builder().build());
        baseUrl = "http://localhost:" + port + "/student/";
    }
    @Order(1)
    @Test
    void create() {
        String url = baseUrl + "create/";
        System.out.println("url = " + url);
        ResponseEntity<Student> response = restTemplate.postForEntity(url, student, Student.class);
        System.out.println("response = " + response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Order(4)
    @Test
    void readAll() {
        String url = baseUrl + "getAll/";
        System.out.println("url = " + url);
        ResponseEntity<Student[]> response = restTemplate.getForEntity(url, Student[].class);
        System.out.println(Arrays.asList(Objects.requireNonNull(response.getBody())));
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Order(2)
    @Test
    void readById() {
        String url = baseUrl + "get/" + student.getStudentId();
        System.out.println("url = " + url);
        ResponseEntity<Student> response = restTemplate.getForEntity(url, Student.class);
        System.out.println("response = " + response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
    @Order(3)
    @Test
        //@Disabled
    void delete() {
        String url = baseUrl + "delete/" + student.getStudentId();
        System.out.println("url = " + url);
        restTemplate.delete(url);
    }





}
