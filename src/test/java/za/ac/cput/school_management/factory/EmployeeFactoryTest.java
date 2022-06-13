package za.ac.cput.school_management.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.EmployeeAddress;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    @Test
    void createEmployeeAddress() {
        EmployeeAddress employeeAddress = EmployeeFactory.createEmployeeAddress(
                "1",
                "1",
                "Richmond",
                "35",
                "Richmond Avenue",
                5);
        assertNotNull(employeeAddress);
        System.out.println("employeeAddress = " + employeeAddress);
    }
}