package za.ac.cput.school_management.service.Country;
/**
 *
 * Humaam Mohamed
 * 214044750
 * ICountry Service
 *
 */

import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.service.IService;

import java.util.Optional;

public interface ICountryService extends IService<Country, String> {
    Optional<Country> findByCountryId(String countryId);
}
