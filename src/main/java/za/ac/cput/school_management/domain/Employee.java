package za.ac.cput.school_management.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "staff_id", updatable = false,nullable = false, length = 50)
    private String staffId;
    @Column(name = "email", updatable = false,nullable = false, length = 50)
    private String email;
    @Embedded
    private Name name;
}


