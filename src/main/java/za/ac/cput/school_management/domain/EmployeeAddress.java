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
/*
Author: Manasseh Barnes
StudentNumber: 218009615
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employee_address")
public class EmployeeAddress implements Serializable {
    @Id
    @NotNull
    @Column(
            name = "staff_id",
            length = 10
    )
    private String staffId;
    @JsonIgnore
    @OneToOne(
            mappedBy = "employeeAddress"
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Employee employee;

    @NotNull
    @Embedded
    private Address address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EmployeeAddress that = (EmployeeAddress) o;
        return staffId != null && Objects.equals(staffId, that.staffId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}