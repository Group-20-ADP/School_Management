package za.ac.cput.school_management.service.implementation;
/**
 * Author       : Kurtney Clyde Jantjies 218138105
 * Due Created : 18/06/2022
 * Description  : School Management System(Milestone Project)
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.school_management.domain.Employee;
import za.ac.cput.school_management.repository.EmployeeRepository;
import za.ac.cput.school_management.service.IEmployeeService;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    private final EmployeeRepository repository;

    @Autowired public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Optional<Employee> readById(String staffId) {
        return repository.findById(staffId);
    }

    @Override
    public List<Employee> readAll() {
        return repository.findAll();
    }

    @Override
    public void delete(String staffId) {
        Optional<Employee> employee = readById(staffId);
        employee.ifPresent(repository::delete);
    }

    @Override
    public Employee findByEmail(String email) {
        return repository.findEmployeeByEmail(email);
    }

    @Override
    public List<Employee> findByCity(String cityId) {
        return null;
    }
}
