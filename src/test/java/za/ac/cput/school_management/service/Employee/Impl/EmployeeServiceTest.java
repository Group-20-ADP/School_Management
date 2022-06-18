package za.ac.cput.school_management.service.Employee.Impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.school_management.domain.Employee;
import za.ac.cput.school_management.domain.valueobjects.Name;
import za.ac.cput.school_management.factory.EmployeeFactory;
import za.ac.cput.school_management.factory.NameFactory;

class EmployeeServiceTest {
    Name name = NameFactory.createName("Rob", "da", "banks");
    private final Employee employee = EmployeeFactory.createEmployee("1","kurtjan@gmail.com",name);


    private final EmployeeService service;

    @Autowired
    EmployeeServiceTest(EmployeeService service) {
        this.service = service;
    }

    @Test
    void create() {
        service.create(employee);
        System.out.println("Employee Created");
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