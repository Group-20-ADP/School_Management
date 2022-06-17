package za.ac.cput.school_management.controller;
/**
 * Author       : Kurtney Clyde  218138105
 * Due Created : 18/06/2022
 * Description  : School Management System(Milestone Project)
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.school_management.domain.Employee;
import za.ac.cput.school_management.domain.valueobjects.Name;
import za.ac.cput.school_management.service.implementation.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired private EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> create(@RequestBody @Validated Employee employee) {
        try {
            return new ResponseEntity<>(employeeService.create(employee), HttpStatus.CREATED);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> readAll() {
        List<Employee> employees = employeeService.readAll();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> readById(@PathVariable String id) {
        Employee employee = employeeService.readById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        employeeService.delete(id);
        return ResponseEntity.ok("Employee Deleted");
    }

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<Name> findByEmail(@PathVariable String email) {
        Employee employee = employeeService.findByEmail(email);
        return ResponseEntity.ok(employee.getName());
    }
}
