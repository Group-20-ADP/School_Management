package za.ac.cput.school_management.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.Student;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Athini Mbiko
 * 213196379
 * Student Factory tester
 */
public class StudentFactoryTest {
    @Test
    void createStudentWithInvalidEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Student student = StudentFactory.createStudent("12345", "somenonsense",
                    "Rob", "da", "banks");
        });
        System.out.println("exception = " + exception.getMessage());
    }

    @Test
    void createCorrectStudent() {
        Student student = StudentFactory.createStudent("12345", "test@bob.com",
                "Rob", "da", "banks");
        assertNotNull(student);
        assertEquals("12345", student.getStudentId());
        System.out.println("student with id " + student.getStudentId() + " has been created");
    }
}
