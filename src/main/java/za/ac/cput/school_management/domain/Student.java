package za.ac.cput.school_management.domain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.ac.cput.school_management.domain.StudentAddress;
import za.ac.cput.school_management.domain.valueobject.name;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @Column(
            name = "student_id",
            length = 10
    )
    private String studentId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private StudentAddress studentAddress;

    @Column(
            name = "email_address",
            length = 50
    )
    private String email;

    @Embedded
    private Name name;
}