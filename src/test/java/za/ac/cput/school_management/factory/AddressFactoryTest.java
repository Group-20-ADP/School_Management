package za.ac.cput.school_management.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.Address;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {

    @Test
    void createAddress() {
        Address address = AddressFactory.createAddress(
                "1",
                "Richmond",
                "35",
                "Richmond Avenue",
                5);
        assertNotNull(address);
    }
}