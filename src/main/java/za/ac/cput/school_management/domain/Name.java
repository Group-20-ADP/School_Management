package za.ac.cput.school_management.domain;

import com.sun.istack.NotNull;
import lombok.*;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
public class Name {
    private String firstName, middleName, lastName;

    private Name(Builder builder){
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return firstName.equals(name.firstName) && middleName.equals(name.middleName) && lastName.equals(name.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName);
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class Builder{
        private String firstName, middleName, lastName;

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder middleName(String middleName){
            this.middleName = middleName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder copy(Name name){
            this.firstName = name.firstName;
            this.middleName = name.middleName;
            this.lastName = name.lastName;
            return this;
        }

        public Name build(){
            return new Name(this);
        }

    }
}
