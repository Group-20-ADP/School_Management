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

    private Student(Builder builder){
        this.studentId =builder.studentId;
        this.email = builder.email;
        this.name = builder.name;
    }
    public static class Builder{
        private String studentId, email;
        private Name name;

        public Builder studentId(String studentId){
            this.studentId = studentId;
            return this;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "studentId='" + studentId + '\'' +
                    ", email='" + email + '\'' +
                    ", name=" + name +
                    '}';
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }



        public Builder name(Name name){
            this.name = name;
            return this;
        }

        public Student build(){
            return new Student(this);
        }
    }

}
