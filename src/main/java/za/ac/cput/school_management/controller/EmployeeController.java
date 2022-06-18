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
import za.ac.cput.school_management.api.EmployeeAddressAPI;
import za.ac.cput.school_management.domain.Employee;
import za.ac.cput.school_management.domain.valueobjects.Name;
import za.ac.cput.school_management.service.Employee.IEmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final IEmployeeService employeeService;
    private final EmployeeAddressAPI employeeAddressAPI;

    @Autowired
    private EmployeeController(IEmployeeService employeeService, EmployeeAddressAPI employeeAddressAPI) {
        this.employeeService = employeeService;
        this.employeeAddressAPI = employeeAddressAPI;
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
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> employees = employeeService.findAll();
        System.out.println("employees = " + employees);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> findById(@PathVariable String id) {
        try{
            Employee employee = employeeService.findById(id);
            return ResponseEntity.ok(employee);
        }catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        try{
            employeeService.delete(id);
            return ResponseEntity.ok("Employee Deleted");
        }catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
    }

    @GetMapping("/findby-email/{email}")
    public ResponseEntity<Name> findByEmail(@PathVariable String email) {
        try{
            Employee employee = employeeService.findByEmail(email);
            return ResponseEntity.ok(employee.getName());
        }catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
    }
//
//    @GetMapping("/findby-city/{city}")
//    public ResponseEntity<List<Employee>> findByCity(@PathVariable String city) {
//        try{
//            List<Employee> employees = employeeAddressAPI.getEmployeeName(city, );
//            return ResponseEntity.ok(employees);
//        }catch (Exception ex){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
//        }
}