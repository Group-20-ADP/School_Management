package za.ac.cput.school_management.service.Employee.Impl;

import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.Employee;
import za.ac.cput.school_management.domain.valueobjects.Name;
import za.ac.cput.school_management.factory.EmployeeFactory;
import za.ac.cput.school_management.factory.NameFactory;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    Name name = NameFactory.createName("Rob", "da", "banks");
    private final Employee employee = EmployeeFactory.createEmployee("1","kurtjan@gmail.com",name);


    @Test
    void create() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void delete() {
    }

    @Test
    void findByEmail() {
    }
}