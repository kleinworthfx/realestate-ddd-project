/*
Property.Java
property Factory class
Author: Francine Mulangu Kasongo 230978649
25/03/2026
 */

package za.ac.cput.realestate.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.realestate.domain.Property;
import static org.junit.jupiter.api.Assertions.*;

class PropertyFactoryTest {

    @Test
    void createProperty_Success() {
        Property property = PropertyFactory.createProperty(
                "P001", "123 Main St", 250000.00, 3, 2.5, "House", "Available"
        );

        assertNotNull(property);
        assertEquals("P001", property.getPropertyId());
        assertEquals("123 Main St", property.getAddress());
        assertEquals(250000.00, property.getPrice());
        assertEquals(3, property.getBedrooms());
        assertEquals(2.5, property.getBathrooms());
        assertEquals("House", property.getPropertyType());
        assertEquals("Available", property.getStatus());
    }

    @Test
    void createProperty_WithGeneratedId() {
        Property property = PropertyFactory.createProperty(
                "123 Main St", 250000.00, 3, 2.5, "House", "Available"
        );

        assertNotNull(property);
        assertNotNull(property.getPropertyId());
    }

    @Test
    void createProperty_NullPropertyId_ReturnsNull() {
        Property property = PropertyFactory.createProperty(
                null, "123 Main St", 250000.00, 3, 2.5, "House", "Available"
        );
        assertNull(property);
    }

    @Test
    void createProperty_EmptyAddress_ReturnsNull() {
        Property property = PropertyFactory.createProperty(
                "P001", "", 250000.00, 3, 2.5, "House", "Available"
        );
        assertNull(property);
    }

    @Test
    void createProperty_NegativePrice_ReturnsNull() {
        Property property = PropertyFactory.createProperty(
                "P001", "123 Main St", -100.00, 3, 2.5, "House", "Available"
        );
        assertNull(property);
    }

    @Test
    void createProperty_ZeroBedrooms_ReturnsNull() {
        Property property = PropertyFactory.createProperty(
                "P001", "123 Main St", 250000.00, 0, 2.5, "House", "Available"
        );
        assertNull(property);
    }

    @Test
    void createProperty_NullPropertyType_ReturnsNull() {
        Property property = PropertyFactory.createProperty(
                "P001", "123 Main St", 250000.00, 3, 2.5, null, "Available"
        );
        assertNull(property);
    }
}