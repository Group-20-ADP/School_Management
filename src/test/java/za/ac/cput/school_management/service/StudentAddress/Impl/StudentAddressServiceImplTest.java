package za.ac.cput.school_management.service.StudentAddress.Impl;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.domain.StudentAddress;
import za.ac.cput.school_management.domain.valueobjects.Address;
import za.ac.cput.school_management.factory.AddressFactory;
import za.ac.cput.school_management.factory.CityFactory;
import za.ac.cput.school_management.factory.CountryFactory;
import za.ac.cput.school_management.factory.StudentAddressFactory;
import za.ac.cput.school_management.service.City.Impl.CityServiceImpl;
import za.ac.cput.school_management.service.Country.Impl.CountryServiceImpl;
import za.ac.cput.school_management.service.StudentAddress.impl.StudentAddressServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class StudentAddressServiceImplTest {

    @Autowired
    private StudentAddressServiceImpl studentAddressService;

    @Autowired
    private CountryServiceImpl countryService;

    @Autowired
    private CityServiceImpl cityService;

    @Autowired
    private AddressServiceImpl addressService;

    private static Country country = CountryFactory.createCountry("786", "South Africa");
    private static City city = CityFactory.createCity("909", "Queens", country);
    private static Address address = AddressFactory.createAddress("20X", "Hanover", "07","St Marks",4447, city);

    private static StudentAddress studentAddress;


    @Test
    void a_initialise(){
        assertNotNull(countryService.create(country));
        assertNotNull(cityService.create(city));
        assertNotNull(addressService.create(address));
        studentAddress = StudentAddressFactory.createStudentAddress("4XX", address);
        assertNotNull(studentAddress);
    }

    @Test
    void aa_create() {
        StudentAddress x = studentAddressService.create(studentAddress);
        assertNotNull(studentAddressService.create(x));
        System.out.println(x.toString());
    }

    @Test
    void b_read() {
        assertEquals("4XX",studentAddressService.read("4XX").getId());
    }

    @Test
    void c_update() {
        Address newAddress =  AddressFactory.createAddress("21J", "BMW", "91","Sweet",4114, city);
        newAddress = addressService.create(newAddress);
        studentAddress = new StudentAddress.Builder().copy(studentAddress).setAddressId(newAddress.getUnitNumber()).build();
        StudentAddress updated = studentAddressService.update(studentAddress);
        assertEquals(1, studentAddressService.getAll().size());
    }

    @Test
    void e_delete() {
        studentAddressService.delete(studentAddress);
        assertEquals(0, studentAddressService.getAll().size());
        System.out.println(studentAddressService.getAll());
    }

    @Test
    void d_getAll() {
        assertEquals(1, studentAddressService.getAll().size());
        System.out.println(studentAddressService.getAll());
    }
}
