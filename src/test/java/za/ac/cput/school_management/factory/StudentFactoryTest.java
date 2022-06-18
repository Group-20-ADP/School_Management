package za.ac.cput.school_management.factory;

import za.ac.cput.school_management.domain.Student;
import za.ac.cput.school_management.domain.valueobjects.Name;

public class StudentFactoryTest {
    public static Student createStudent(String studentId, String email, String firstName, String middleName,
                                        String lastName){

        Name name = NameFactory.createName(firstName,middleName,lastName);
        return Student.builder()
                .studentId(studentId)
                .email(email)
                .name(name)
                .build();
    }
}
