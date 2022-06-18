package za.ac.cput.school_management.service.Student.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.school_management.domain.Student;
import za.ac.cput.school_management.repository.StudentRepository;
import za.ac.cput.school_management.service.Student.IStudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> findLastnameByCountryId(String countryId) {
        return null;
    }

    @Override
    public Student create(Student student) {
        return repository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Student findById(String id) {
        return repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Student not found"));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}

