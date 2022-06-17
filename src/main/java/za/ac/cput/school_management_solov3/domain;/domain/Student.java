package za.ac.cput.school_management.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private za.ac.cput.school_management.domain.StudentAddress studentAddress;

    @Column(
            name = "email_address",
            length = 50
    )
    private String email;

    @Embedded
    private za.ac.cput.school_management.domain.Name name;
}
