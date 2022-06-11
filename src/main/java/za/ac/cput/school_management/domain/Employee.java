package za.ac.cput.school_management.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_sequence")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    @Column(name = "staff_id", updatable = false,nullable = false, length = 50)
    private String staffId;
    @Column(name = "email", updatable = false,nullable = false, length = 50)
    private String email;
    @Embedded
    private Name name;

    private Employee(Builder builder){
        this.staffId = builder.staffId;
        this.email = builder.email;
        this.name = builder.name;
    }

    public static class Builder{
        private String staffId, email;
        private Name name;

        public Builder staffId(String staffId){
            this.staffId = staffId;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder name(Name name){
            this.name = name;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }
}


