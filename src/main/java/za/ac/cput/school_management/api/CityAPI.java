package za.ac.cput.school_management.api;

/*
Author: Manasseh Barnes
StudentNumber: 218009615
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.service.City.ICityService;
import za.ac.cput.school_management.service.Country.ICountryService;

@Component
public class CityAPI {
    private final ICountryService countryService;
    private final ICityService cityService;

    @Autowired
    public CityAPI(ICountryService countryService, ICityService cityService) {
        this.countryService = countryService;
        this.cityService = cityService;
    }

    public City save(City city) {
        try{
            if(countryService.findById(city.getCountry().getId()) != null){
                return cityService.create(city);
            }
            else{
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Country ID not found, Please create Country first");
            }
        } catch (IllegalArgumentException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Country ID not found, Please create Country first");
        }
    }
}
