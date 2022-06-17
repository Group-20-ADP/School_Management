package za.ac.cput.school_management.service;
/**
 * Author       : Kurtney Clyde Jantjies 218138105
 * Due Created : 18/06/2022
 * Description  : School Management System(Milestone Project)
 */

import za.ac.cput.school_management.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService extends IService<Employee, String> {
    Optional<Employee> readById(String staffId);

    //employee name given an employee email
    Employee findByEmail(String email);

    //retrieve all employee name(s) living in a particular city
    List<Employee> findByCity(String cityId);
}
