package za.ac.cput.school_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.school_management.api.CityAPI;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.service.City.ICityService;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    private final ICityService cityService;
    private final CityAPI cityAPI;

    @Autowired
    public CityController(ICityService cityService, CityAPI cityAPI) {
        this.cityService = cityService;
        this.cityAPI = cityAPI;
    }

    @PostMapping("/create")
    public ResponseEntity<City> create(@RequestBody @Validated City city) {
        cityAPI.save(city);
        return ResponseEntity.ok(city);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<City>> findAll() {
        List<City> city = cityService.findAll();
        return ResponseEntity.ok(city);
    }

    @GetMapping("/get/{cityId}")
    public ResponseEntity<City> findById(@PathVariable String cityId) {
        try{
            City city = cityService.findById(cityId);
            return ResponseEntity.ok(city);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/delete/{cityId}")
    public ResponseEntity<String> delete(@PathVariable String cityId) {
        try {
            cityService.delete(cityId);
            return ResponseEntity.ok("City Deleted");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/city-by-country/{countryId}")
    public ResponseEntity<List<City>> findByCountryId(@PathVariable String countryId) {
        try{
            List<City> city = cityService.findByCountryId(countryId);
            return ResponseEntity.ok(city);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
