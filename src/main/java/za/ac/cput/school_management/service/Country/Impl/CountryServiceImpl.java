package za.ac.cput.school_management.service.Country.Impl;
/**
 *
 * Humaam Mohamed
 * 214044750
 * Country Service Impl
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.repository.CountryRepository;
import za.ac.cput.school_management.service.Country.ICountryService;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements ICountryService {

    private final CountryRepository repository;

    @Autowired
    public CountryServiceImpl(CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Country create(Country country) {
        return repository.save(country);
    }

    @Override
    public List<Country> findAll() {
        return repository.findAll();
    }

    @Override
    public Country findById(String id) {
        return repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No Country found for id " + id));
    }

    @Override
    public void delete(String s) {
        repository.deleteById(s);
    }

    @Override
    public Optional<Country> findByCountryId(String countryId) {
        return Optional.empty();
    }
}
