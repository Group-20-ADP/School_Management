package za.ac.cput.school_management.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.Student;
import za.ac.cput.school_management.domain.valueobjects.Name;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {
    @Test
    void createStudentWithInvalidEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Student student = StudentFactory.createStudent("12345", "somenonsense", Name.builder().build());
        });
        System.out.println("exception = " + exception.getMessage());
    }

    @Test
    void createCorrectStudent() {
        Student student = StudentFactory.createStudent("12345", "test@bob.com",
                Name.builder().build());
        assertNotNull(student);
        assertEquals("12345", student.getStudentId());
        System.out.println("student with id " + student.getStudentId() + " has been created");
    }
}