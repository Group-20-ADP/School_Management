package za.ac.cput.school_management.controller;
/**
 *
 * Humaam Mohamed
 * 214044750
 * Country Controller
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.service.Country.ICountryService;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    private final ICountryService countryService;

    @Autowired
    private CountryController(ICountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("/create")
    public ResponseEntity<Country> create(@RequestBody @Validated Country country) {
        try {
            return new ResponseEntity<>(countryService.create(country), HttpStatus.CREATED);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Country>> findAll() {
        List<Country> countries = countryService.findAll();
        return ResponseEntity.ok(countries);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Country> findById(@PathVariable String id) {
        try{
            Country country = countryService.findById(id);
            return ResponseEntity.ok(country);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        try{
            countryService.delete(id);
            return ResponseEntity.ok("Country Deleted");
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not found");
        }
    }
}

