package za.ac.cput.school_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.cput.school_management.domain.Employee;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Query("select u from Employee as u where u.email = :email")
    Optional<Employee> findByEmail(@Param("email") String email);
}