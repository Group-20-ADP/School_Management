/**
 * Athini Mbiko
 * 213196379
 * Student Service implements
 */
package za.ac.cput.school_management.service.implementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.school_management.domain.Student;
import za.ac.cput.school_management.repository.StudentRepository;
import za.ac.cput.school_management.service.IStudentService;

import java.util.List;
@Service

public class StudentImpl implements IStudentService {

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
