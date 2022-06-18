package za.ac.cput.school_management.controller;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import za.ac.cput.school_management.domain.Student;
import za.ac.cput.school_management.domain.valueobjects.Name;
import za.ac.cput.school_management.factory.CountryFactory;
import za.ac.cput.school_management.factory.StudentFactory;

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
        baseUrl = "http://localhost:" + port + "/country/";
    }



}
