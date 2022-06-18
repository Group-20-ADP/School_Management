package za.ac.cput.school_management.service.Employee;
/**
 * Author       : Kurtney Clyde Jantjies 218138105
 * Due Created : 18/06/2022
 * Description  : School Management System(Milestone Project)
 */

import za.ac.cput.school_management.domain.Employee;
import za.ac.cput.school_management.service.IService;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService extends IService<Employee, String> {
    Employee findByEmail(String email);
}
