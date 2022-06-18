package za.ac.cput.school_management.repository;
/**
 *
 * Humaam Mohamed
 * 214044750
 * Country Repository
 *
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.school_management.domain.Country;


@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
}
