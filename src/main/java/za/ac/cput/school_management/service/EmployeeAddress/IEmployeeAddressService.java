package za.ac.cput.school_management.service.EmployeeAddress;

import za.ac.cput.school_management.domain.EmployeeAddress;
import za.ac.cput.school_management.service.IService;

import java.util.List;
/*
Author: Manasseh Barnes
StudentNumber: 218009615
 */
public interface IEmployeeAddressService extends IService<EmployeeAddress, String> {
    EmployeeAddress findEmployeeByCityId(String cityId);
}
