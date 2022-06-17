/**
 * Athini Mbiko
 * 213196379
 * Student Service
 */
package za.ac.cput.school_management.service;
import za.ac.cput.school_management.domain.EmployeeAddress;
import za.ac.cput.school_management.domain.Student;

import java.util.List;

public interface IStudent {

    Student create(Student student);

    Student read(String StudentId);

    List<Student> readAll();

    void delete(String StudentId);



}
