package za.ac.cput.school_management.domain;

/**
 *
 * Moegamad Nur Duncan
 * 220014442
 * City Entity
 *
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@Entity
public class City implements Serializable {
    @Id
    @NotNull
    @Column(
            name = "city_id",
            length = 10,
            unique = true
    )
    private String id;

    @Column(
            name = "city_Name"
    )
    private String name;

    @JsonIgnore
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(
            name = "country_id"
    )
    private Country country;
}