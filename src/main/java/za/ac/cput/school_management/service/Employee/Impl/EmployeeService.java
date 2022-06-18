package za.ac.cput.school_management.service.Employee.Impl;
/**
 * Author       : Kurtney Clyde Jantjies 218138105
 * Due Created : 18/06/2022
 * Description  : School Management System(Milestone Project)
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.school_management.domain.Employee;
import za.ac.cput.school_management.repository.EmployeeRepository;
import za.ac.cput.school_management.service.Employee.IEmployeeService;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(String id) {
        return repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No Employee found for id " + id));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public Employee findByEmail(String email) {
        try{
            return repository.findEmployeeByEmail(email);
        } catch (Exception ex) {
            throw new NullPointerException("No Employee found for email " + email);
        }
    }
}
