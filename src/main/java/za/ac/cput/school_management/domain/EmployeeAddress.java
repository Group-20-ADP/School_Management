package za.ac.cput.school_management.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeAddress {
    private String staffId;

    @Embedded
    private Address address;
}
