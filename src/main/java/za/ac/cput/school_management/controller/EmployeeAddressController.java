package za.ac.cput.school_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.school_management.api.EmployeeAddressAPI;
import za.ac.cput.school_management.domain.EmployeeAddress;
import za.ac.cput.school_management.service.EmployeeAddress.IEmployeeAddressService;

import java.util.List;

@RestController
@RequestMapping("/employee-address")
public class EmployeeAddressController {
    private final IEmployeeAddressService employeeAddressService;
    private final EmployeeAddressAPI employeeAddressAPI;

    @Autowired
    public EmployeeAddressController(IEmployeeAddressService employeeAddressService, EmployeeAddressAPI employeeAddressAPI) {
        this.employeeAddressService = employeeAddressService;
        this.employeeAddressAPI = employeeAddressAPI;
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeeAddress> create(@RequestBody @Validated EmployeeAddress employeeAddress) {
        EmployeeAddress save = employeeAddressAPI.save(employeeAddress);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeAddress>> findAll() {
        List<EmployeeAddress> employeeAddress = employeeAddressService.findAll();
        return ResponseEntity.ok(employeeAddress);
    }

    @GetMapping("/get/{staffId}")
    public ResponseEntity<EmployeeAddress> findById(@PathVariable String staffId) {
        try{
            EmployeeAddress employeeAddress = employeeAddressService.findById(staffId);
            return ResponseEntity.ok(employeeAddress);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/delete/{staffId}")
    public ResponseEntity<String> delete(@PathVariable String staffId) {
        try{
            employeeAddressService.delete(staffId);
            return ResponseEntity.ok("Employee Address Deleted");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
