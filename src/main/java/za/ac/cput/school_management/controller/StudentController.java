package za.ac.cput.school_management.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.school_management.domain.Student;
import za.ac.cput.school_management.service.IStudentService;

import java.util.List;

@RestController
@RequestMapping("/student")

public class StudentController {
    private final IStudentService studentService;

    @Autowired private StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> create(@RequestBody @Validated Student student) {
        try {
            return new ResponseEntity<>(studentService.create(student), HttpStatus.CREATED);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> readAll() {
        List<Student> students = studentService.readAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> readById(@PathVariable String id) {
        Student student = studentService.readById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "student not found"));
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        studentService.delete(id);
        return ResponseEntity.ok("student Deleted");
    }
//      FindLastNameByCountryID
//    @GetMapping("/findByEmail/{email}")
//    public ResponseEntity<Name> findByEmail(@PathVariable String email) {
//        Student student = studentService.findByEmail(email);
//        return ResponseEntity.ok(student.getName());
//    }
}
