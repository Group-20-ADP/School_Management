package za.ac.cput.school_management.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.school_management.domain.StudentAddress;
import za.ac.cput.school_management.service.Student.IStudentService;
import za.ac.cput.school_management.service.StudentAddress.IStudentAddressService;

@Component
public class StudentAddressAPI {
    private final IStudentService studentService;
    private final IStudentAddressService studentAddressService;

    @Autowired
    public StudentAddressAPI(IStudentService studentService, IStudentAddressService studentAddressService) {
        this.studentService = studentService;
        this.studentAddressService = studentAddressService;
    }

    public StudentAddress save(StudentAddress studentAddress) {
        try{
            if(studentService.findById(studentAddress.getStudentId()) != null){
                return studentAddressService.create(studentAddress);
            }
            else{
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student ID not found, Please create Student first");
            }
        } catch (IllegalArgumentException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student ID not found, Please create Student first");
        }
    }
}
