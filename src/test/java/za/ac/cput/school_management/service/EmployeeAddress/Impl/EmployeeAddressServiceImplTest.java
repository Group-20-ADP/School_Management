package za.ac.cput.school_management.service.EmployeeAddress.Impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.school_management.domain.EmployeeAddress;
import za.ac.cput.school_management.factory.AddressFactory;
import za.ac.cput.school_management.factory.CityFactory;
import za.ac.cput.school_management.factory.CountryFactory;
import za.ac.cput.school_management.factory.EmployeeAddressFactory;
import za.ac.cput.school_management.repository.EmployeeAddressRepository;

class EmployeeAddressServiceImplTest {

    private final EmployeeAddressRepository repository;

    @Autowired
    EmployeeAddressServiceImplTest(EmployeeAddressRepository repository) {
        this.repository = repository;
    }

    @Test
    void create() {
        //create a new employee address
        EmployeeAddress employeeAddress = EmployeeAddressFactory.createEmployeeAddress(
                "E123",
                AddressFactory.createAddress(
                        "123", "123", "123",
                        "123", 2000,
                        CityFactory.createCity("CPT", "Cape Town",
                                CountryFactory.createCountry("ZA", "South Africa"))));
        repository.save(employeeAddress);
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void delete() {
    }

    @Test
    void findEmployeeByCityId() {
    }
}