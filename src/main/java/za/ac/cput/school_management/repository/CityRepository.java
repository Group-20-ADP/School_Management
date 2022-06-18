package za.ac.cput.school_management.repository;

/**
 *
 * Moegamad Nur Duncan
 * 220014442
 * City Repository
 *
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.school_management.domain.City;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository <City, String> {
    //@Query("select c from City c where c.country.id = ?1")
    List<City> findCityNameByCountryId(String countryId);
}
