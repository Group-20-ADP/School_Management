/**
 * Athini Mbiko
 * 213196379
 * Student Service
 */
package za.ac.cput.school_management.service.Student;
import za.ac.cput.school_management.domain.Student;
import za.ac.cput.school_management.service.IService;

import java.util.List;
import java.util.Optional;

public interface IStudentService extends IService<Student, String> {
    List<Student> findLastnameByCountryId(String countryId);
}
