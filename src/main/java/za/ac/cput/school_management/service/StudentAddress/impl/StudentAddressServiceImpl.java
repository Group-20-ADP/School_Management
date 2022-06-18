package za.ac.cput.school_management.service.StudentAddress.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.school_management.domain.StudentAddress;
import za.ac.cput.school_management.repository.StudentAddressRepository;
import za.ac.cput.school_management.service.StudentAddress.IStudentAddressService;

import java.util.Collection;
import java.util.List;


@Service
public class StudentAddressServiceImpl implements IStudentAddressService {
    private final StudentAddressRepository repository;

    @Autowired
    public StudentAddressServiceImpl(StudentAddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentAddress create(StudentAddress studentAddress) {
        return repository.save(studentAddress);
    }

    @Override
    public List<StudentAddress> findAll() {
        return repository.findAll();
    }

    @Override
    public StudentAddress findById(String id) {
        return repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("StudentAddress not found"));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}

