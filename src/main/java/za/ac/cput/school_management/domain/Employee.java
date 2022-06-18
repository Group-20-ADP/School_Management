package za.ac.cput.school_management.domain;
/**
 * Author       : Kurtney Clyde Jantjies 218138105
 * Due Created : 18/06/2022
 * Description  : School Management System(Milestone Project)
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import za.ac.cput.school_management.domain.valueobjects.Name;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
@Table(name = "employee")
public class Employee implements Serializable {
    @Id
    @NotNull
    @Column(name = "staff_id", length = 10)
    private String staffId;
    @JsonIgnore
    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "staff_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private EmployeeAddress employeeAddress;

    @NotNull
    @Column(name = "email_address", length = 50)
    private String email;

    @NotNull
    @Embedded
    private Name name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Employee employee = (Employee) o;
        return staffId != null && Objects.equals(staffId, employee.staffId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}



