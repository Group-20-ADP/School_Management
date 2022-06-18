package za.ac.cput.school_management.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.ac.cput.school_management.domain.valueobjects.Address;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "student_address")
public class StudentAddress {
    @Id
    @Column(
            name = "student_id",
            length = 10
    )
    private String studentId;
    @OneToOne(
            mappedBy = "studentAddress"
    )
    private Student student;

    @Embedded
    private Address address;
}
