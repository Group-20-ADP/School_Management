package za.ac.cput.school_management.api;


/*
Author: Manasseh Barnes
StudentNumber: 218009615
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.school_management.domain.EmployeeAddress;
import za.ac.cput.school_management.service.Employee.IEmployeeService;
import za.ac.cput.school_management.service.EmployeeAddress.IEmployeeAddressService;

@Component
public class EmployeeAddressAPI {
    private final IEmployeeService employeeService;
    private final IEmployeeAddressService employeeAddressService;

    @Autowired
    public EmployeeAddressAPI(IEmployeeService employeeService, IEmployeeAddressService employeeAddressService) {
        this.employeeService = employeeService;
        this.employeeAddressService = employeeAddressService;
    }

    public EmployeeAddress save(EmployeeAddress employeeAddress) {
        try{
            if(employeeService.findById(employeeAddress.getStaffId()) != null){
                return employeeAddressService.create(employeeAddress);
            }
            else{
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee ID not found, Please create Employee first");
            }
        } catch (IllegalArgumentException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee ID not found, Please create Employee first");
        }
    }
//
//    //Get Employee Name
//    public Name getEmployeeName(String cityId){
//        employeeAddressService.findEmployeeByCityId(cityId);
//        employeeAddressService.findById(staffId);
//        if (Objects.equals(cityId, staffId)){
//            return employeeService.findById(staffId).getName();
//        }else{
//            return null;
//        }
//    }
}
