package za.ac.cput.school_management.service.City;

import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.service.IService;

import java.util.List;

public interface ICityService extends IService<City, String> {
        List<City> findByCountryId(String countryId);
    }

