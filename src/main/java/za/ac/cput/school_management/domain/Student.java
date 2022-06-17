package za.ac.cput.school_management.domain;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.ac.cput.school_management.domain.ValueObjects.Name;

import javax.persistence.*;
import java.io.Serializable;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

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
    private StudentAddress studentAddress;

    @Column(
            name = "email_address",
            length = 50
    )
    private String email;

    @Embedded
    private Name name;
}
