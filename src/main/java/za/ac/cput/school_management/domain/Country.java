package za.ac.cput.school_management.domain;

/**
 *
 * Humaam Mohamed
 * 214044750
 * Country Entity.
 *
 */

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@Entity
public class Country {
    @Id
    @NotNull
    @Column(
            name = "Country_id",
            length = 10,
            unique = true,
            nullable = false,
            updatable = false
    )
    private String id;

    @Column(
            name = "Country_Name"
    )
    private String name;
}
