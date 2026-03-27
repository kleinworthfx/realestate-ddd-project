/*
Property.Java
property model class
Author: Francine Mulangu Kasongo 230978649
25/03/2026
 */

package za.ac.cput.realestate.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.realestate.domain.Property;

import static org.junit.jupiter.api.Assertions.*;

    class PropertyFactoryTest {

        @Test
        void testCreateProperty() {
            Property property = PropertyFactory.createProperty(
                    "P001",
                    "123 Main Street",
                    2500000.00,
                    1,
                    2.0,
                    2,
                    1,
                    "house",
                    "Available"
            );

            assertNotNull(property);
            assertEquals("P001", property.getPropertyId());
            assertEquals("123 Main Street", property.getAddress());
            assertEquals(2500000.00, property.getPrice());
            assertEquals(3, property.getBedrooms());
            assertEquals(2.0, property.getBathrooms());
            assertEquals("House", property.getPropertyType());
            assertEquals("Available", property.getStatus());
        }
    }
