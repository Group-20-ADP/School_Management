package za.ac.cput.school_management.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.*;
import org.hibernate.Hibernate;
import za.ac.cput.school_management.domain.valueobjects.Name;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @NotNull
    @Column(
            name = "student_id",
            length = 10
    )
    private String studentId;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private StudentAddress studentAddress;

    @NotNull
    @Column(
            name = "email_address",
            length = 50
    )
    private String email;

    @NotNull
    @Embedded
    private Name name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return studentId != null && Objects.equals(studentId, student.studentId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
