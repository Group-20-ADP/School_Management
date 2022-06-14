package za.ac.cput.school_management.domain;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "system-uuid",strategy = "uuid")

    @Column(name = "studentId", updatable = false,nullable = false, length = 50)
    private String studentId;

    @Column(name = "email", updatable = false,nullable = false, length = 50)

    private String email;
    @Embedded

    private Name name;







}
