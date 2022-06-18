package za.ac.cput.school_management.repository;
/**
 * Author       : Kurtney Clyde Jantjies 218138105
 * Due Created : 18/06/2022
 * Description  : School Management System(Milestone Project)
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.school_management.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    //Give EmployeeName from Email
    Employee findEmployeeByEmail(String email);

    //@Query("select e from Employee e where e.staffId = ?1")
    Employee findEmployeeByStaffId(String staffId);
}