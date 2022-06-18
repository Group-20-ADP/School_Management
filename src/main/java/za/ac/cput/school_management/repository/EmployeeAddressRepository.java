package za.ac.cput.school_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.cput.school_management.domain.EmployeeAddress;

@Repository
public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress, String> {

    @Query("Select e.staffId from EmployeeAddress e where e.address.city.id = ?1")
    EmployeeAddress findByCityId(String cityId);
}
