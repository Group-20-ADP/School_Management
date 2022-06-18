package za.ac.cput.school_management.service.Student.Impl;

import org.springframework.stereotype.Service;
import za.ac.cput.school_management.domain.Student;
import za.ac.cput.school_management.service.StudentAddress.IStudentAddressService;

import java.util.List;

@Service
public class IStudentServiceImpl implements IStudentAddressService {
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
}
