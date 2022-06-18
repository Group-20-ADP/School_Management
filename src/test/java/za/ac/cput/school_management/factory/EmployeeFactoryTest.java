package za.ac.cput.school_management.factory;
/**
 * Author       : Kurtney Clyde Jantjies
 * Due Created : 18/06/2022
 * Description  : School Management System(Milestone Project)
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.Employee;
import za.ac.cput.school_management.domain.valueobjects.Name;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {
    @Test
    void createEmployeeWithInvalidEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Name name = NameFactory.createName(
                    "Rob", "da", "banks");
            Employee employee = EmployeeFactory.createEmployee("12345", "somenonsense",
                    name);
        });

        System.out.println("exception = " + exception.getMessage());
    }

    @Test
    void createCorrectEmployee() {
        Name name = NameFactory.createName(
                "Rob", "da", "banks");
        Employee employee = EmployeeFactory.createEmployee("12345", "test@bob.com",
                name);
        assertNotNull(employee);
        assertEquals("12345", employee.getStaffId());
        System.out.println("employee with id " + employee.getStaffId() + " has been created");
    }
}