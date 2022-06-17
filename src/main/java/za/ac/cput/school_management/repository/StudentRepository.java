package za.ac.cput.school_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.school_management.domain.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
}
