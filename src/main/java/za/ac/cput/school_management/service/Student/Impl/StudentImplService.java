/**
 * Athini Mbiko
 * 213196379
 * Student Service implements
 */
package za.ac.cput.school_management.service.Student.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.school_management.domain.Student;
import za.ac.cput.school_management.repository.StudentRepository;
import za.ac.cput.school_management.service.Student.IStudentService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentImplService implements IStudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentImplService(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student create(Student student) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student findById(String s) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public List<Student> findLastnameByCountryId(String countryId) {
        return null;
    }
}
