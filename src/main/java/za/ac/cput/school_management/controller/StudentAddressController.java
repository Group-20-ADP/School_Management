package za.ac.cput.school_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.school_management.api.StudentAddressAPI;
import za.ac.cput.school_management.domain.StudentAddress;
import za.ac.cput.school_management.service.StudentAddress.IStudentAddressService;
import java.util.List;

@RestController
@RequestMapping("/student-address")
public class StudentAddressController {
    private final IStudentAddressService studentAddressService;
    private final StudentAddressAPI studentAddressAPI;

    @Autowired
    public StudentAddressController(IStudentAddressService studentAddressService, StudentAddressAPI studentAddressAPI) {
        this.studentAddressService = studentAddressService;
        this.studentAddressAPI = studentAddressAPI;
    }

    @PostMapping("/create")
    public ResponseEntity<StudentAddress> create(@RequestBody @Validated StudentAddress studentAddress) {
        StudentAddress save = studentAddressAPI.save(studentAddress);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentAddress>> findAll() {
        List<StudentAddress> StudentAddress = studentAddressService.findAll();
        return ResponseEntity.ok(StudentAddress);
    }

    @GetMapping("/get/{staffId}")
    public ResponseEntity<StudentAddress> findById(@PathVariable String staffId) {
        try{
            StudentAddress StudentAddress = studentAddressService.findById(staffId);
            return ResponseEntity.ok(StudentAddress);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/delete/{staffId}")
    public ResponseEntity<String> delete(@PathVariable String staffId) {
        try{
            studentAddressService.delete(staffId);
            return ResponseEntity.ok("Student Address Deleted");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
