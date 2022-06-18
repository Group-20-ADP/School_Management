package za.ac.cput.school_management.service.City.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.repository.CityRepository;
import za.ac.cput.school_management.service.City.ICityService;

import java.util.List;

@Service
public class CityServiceImpl implements ICityService {

    private final CityRepository repository;
    @Autowired
    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<City> findByCountryId(String countryId) {
        return repository.findCityNameByCountryId(countryId);
    }

    @Override
    public City create(City city) {
        return repository.save(city);
    }

    @Override
    public List<City> findAll() {
        return repository.findAll();
    }

    @Override
    public City findById(String id) {
        return repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("City not found"));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
