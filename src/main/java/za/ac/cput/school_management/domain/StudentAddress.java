package za.ac.cput.school_management.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import za.ac.cput.school_management.domain.valueobjects.Address;

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
@Table(name = "student_address")
public class StudentAddress implements Serializable {
    @Id
    @NotNull
    @Column(
            name = "student_id",
            length = 10
    )
    private String studentId;
    @JsonIgnore
    @OneToOne(
            mappedBy = "studentAddress"
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Student student;

    @NotNull
    @Embedded
    private Address address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StudentAddress that = (StudentAddress) o;
        return studentId != null && Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}