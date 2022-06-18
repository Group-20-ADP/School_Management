package za.ac.cput.school_management.domain.valueobjects;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class Name implements Serializable {
    @NotNull
    @Column(name = "first_Name")
    private String firstName;

    @Column(name = "middle_Name")
    private String middleName;

    @NotNull
    @Column(name = "last_Name")
    private String lastName;
}
