package za.ac.cput.school_management.domain;
/**
 * Author       : Kurtney Clyde Jantjies 218138105
 * Due Created : 18/06/2022
 * Description  : School Management System(Milestone Project)
 */

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
    @Column(            name = "staff_id", length = 10)
    private String staffId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_id")
    private EmployeeAddress employeeAddress;

    @Column(name = "email_address", length = 50)
    private String email;

    @Embedded
    private Name name;
}



