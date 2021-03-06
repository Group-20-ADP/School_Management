package za.ac.cput.school_management.factory;

import za.ac.cput.school_management.domain.StudentAddress;
import za.ac.cput.school_management.domain.valueobjects.Address;
import za.ac.cput.school_management.utility.Helper;

public class StudentAddressFactory {
    public static StudentAddress createStudentAddress(String studentId, Address address) {

        Helper.checkStringParam(studentId, "studentId");
        Helper.checkIfObjectNull("address", address);

        return StudentAddress.builder()
                .studentId(studentId)
                .address(address)
                .build();
    }
}
