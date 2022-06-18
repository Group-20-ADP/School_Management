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
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@Entity
public class Country implements Serializable {
    @Id
    @NotNull
    @Column(
            name = "Country_id",
            length = 10,
            unique = true
    )
    private String id;

    @Column(
            name = "Country_Name"
    )
    private String name;
}
