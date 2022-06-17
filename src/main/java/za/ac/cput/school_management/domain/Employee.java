package za.ac.cput.school_management.domain;

import com.sun.istack.NotNull;
import lombok.*;
import za.ac.cput.school_management.domain.valueobjects.Name;
import javax.persistence.*;
import java.io.Serializable;

@Data
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_id")
    private EmployeeAddress employeeAddress;

    @Column(name = "email_address", length = 50)
    private String email;

    @Embedded
    private Name name;
}



