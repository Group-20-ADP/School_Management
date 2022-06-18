package za.ac.cput.school_management.service.EmployeeAddress.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.school_management.domain.EmployeeAddress;
import za.ac.cput.school_management.repository.IEmployeeAddressRepository;
import za.ac.cput.school_management.service.EmployeeAddress.IEmployeeAddressService;

import java.util.List;

@Service
public class EmployeeAddressImpl implements IEmployeeAddressService {

    private final IEmployeeAddressRepository repository;


    @Autowired
    public EmployeeAddressImpl(IEmployeeAddressRepository repository) {
        this.repository = repository;
    }


    @Override
    public EmployeeAddress create(EmployeeAddress employeeAddress) {
        return null;
    }

    @Override
    public List<EmployeeAddress> findAll() {
        return null;
    }

    @Override
    public EmployeeAddress findById(String s) {
        return null;
    }

    @Override
    public void delete(String s) {

    }
}
