/**
 * Athini Mbiko
 * 213196379
 * Student Service implements
 */
package za.ac.cput.school_management.service.implementation;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.school_management.domain.Student;
import za.ac.cput.school_management.repository.IEmployeeAddressRepository;
import za.ac.cput.school_management.repository.StudentRepository;
import za.ac.cput.school_management.service.IStudent;

import java.util.List;

public class StudentImpl implements IStudent {

    @Autowired
    private StudentRepository repository;
    @Override
    public Student create(Student student) {
        return repository.save(student);
    }

    @Override
    public Student read(String StudentId) {
         return repository.findById(StudentId).orElse(null);
    }

    @Override
    public List<Student> readAll() {
        return repository.findAll();
    }

    @Override
    public void delete(String StudentId) {
        repository.deleteById(StudentId);

    }
}
