package za.ac.cput.school_management.domain.valueobjects;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import za.ac.cput.school_management.domain.City;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class Address implements Serializable {
    @Column(
            name = "unitNumber"
    )
    private String unitNumber;

    @Column(
            name = "complexName"
    )
    private String complexName;

    @NotNull
    @Column(
            name = "streetNumber"
    )
    private String streetNumber;

    @NotNull
    @Column(
            name = "streetName"
    )
    private String streetName;

    @NotNull
    @Column(
            name = "postalCode"
    )
    private int postalCode;

    @NotNull
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name =
            "city_id"
    )
    private City city;
}
