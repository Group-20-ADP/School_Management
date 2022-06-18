/**
 * Athini Mbiko
 * 213196379
 * Student Factory
 */
package za.ac.cput.school_management.factory;

import za.ac.cput.school_management.domain.valueobjects.Name;
import za.ac.cput.school_management.domain.Student;
import za.ac.cput.school_management.utility.Helper;

public class StudentFactory {
    public static Student createStudent(String studentId, String email, Name name){
        Helper.checkStringParam(studentId, "studentId");
        Helper.checkStringParam(email, "email");
        Helper.checkEmail(email);
        Helper.checkIfObjectNull("name", name);

        return Student.builder()
                .studentId(studentId)
                .email(email)
                .name(name)
                .build();
    }
}
