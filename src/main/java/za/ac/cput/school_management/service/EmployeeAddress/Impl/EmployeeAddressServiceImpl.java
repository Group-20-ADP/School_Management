package za.ac.cput.school_management.service.EmployeeAddress.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.school_management.domain.EmployeeAddress;
import za.ac.cput.school_management.repository.EmployeeAddressRepository;
import za.ac.cput.school_management.service.EmployeeAddress.IEmployeeAddressService;

import java.util.List;

@Service
public class EmployeeAddressServiceImpl implements IEmployeeAddressService {

    private final EmployeeAddressRepository repository;

    @Autowired
    public EmployeeAddressServiceImpl(EmployeeAddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeAddress create(EmployeeAddress employeeAddress) {
        return repository.save(employeeAddress);
    }

    @Override
    public List<EmployeeAddress> findAll() {
        return repository.findAll();
    }

    @Override
    public EmployeeAddress findById(String id) {
        return repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No EmployeeAddress found for id " + id));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public EmployeeAddress findEmployeeByCityId(String cityId){
        return repository.findByCityId(cityId);
    }
}
