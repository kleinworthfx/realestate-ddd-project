/*
Property.Java
property model class
Author: Francine Mulangu Kasongo 230978649
2/03/2026
 */
package za.ac.cput.realestate.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.realestate.domain.Property;
import za.ac.cput.realestate.factory.PropertyFactory;
import za.ac.cput.realestate.repository.impl.PropertyRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PropertyRepositoryTest {

    private static PropertyRepository repository;
    private static Property property1;
    private static Property property2;

    @BeforeAll
    static void setup() {
        repository = PropertyRepository.getRepository();
        property1 = PropertyFactory.createProperty(
                "P001", "123 Main St", 250000.00, 3, 2.5, "House", "Available"
        );
        property2 = PropertyFactory.createProperty(
                "P002", "456 Oak Ave", 180000.00, 2, 1.0, "Apartment", "Sold"
        );
    }

    @BeforeEach
    void clearRepository() {
        // Clear the repository before each test
        repository.getAll().clear();
    }

    @Test
    @Order(1)
    void testCreate() {
        Property created = repository.create(property1);
        assertNotNull(created);
        assertEquals(property1.getPropertyId(), created.getPropertyId());
        assertEquals(1, repository.getAll().size());
    }

    @Test
    @Order(2)
    void testCreate_Duplicate() {
        repository.create(property1);
        Property duplicate = repository.create(property1);
        assertNull(duplicate);
        assertEquals(1, repository.getAll().size());
    }

    @Test
    @Order(3)
    void testCreate_NullProperty() {
        Property created = repository.create(null);
        assertNull(created);
        assertEquals(0, repository.getAll().size());
    }

    @Test
    @Order(4)
    void testRead() {
        repository.create(property1);
        Property read = repository.read(property1.getPropertyId());
        assertNotNull(read);
        assertEquals(property1.getPropertyId(), read.getPropertyId());
    }

    @Test
    @Order(5)
    void testRead_NonExistent() {
        Property read = repository.read("NonExistent");
        assertNull(read);
    }

    @Test
    @Order(6)
    void testRead_NullId() {
        Property read = repository.read(null);
        assertNull(read);
    }

    @Test
    @Order(7)
    void testUpdate() {
        repository.create(property1);
        Property updated = new Property.Builder().copy(property1)
                .setPrice(260000.00)
                .setStatus("Pending")
                .build();
        Property result = repository.update(updated);
        assertNotNull(result);
        assertEquals(260000.00, result.getPrice());
        assertEquals("Pending", result.getStatus());
    }

    @Test
    @Order(8)
    void testUpdate_NonExistent() {
        Property result = repository.update(property1);
        assertNull(result);
    }

    @Test
    @Order(9)
    void testUpdate_NullProperty() {
        Property result = repository.update(null);
        assertNull(result);
    }

    @Test
    @Order(10)
    void testDelete() {
        repository.create(property1);
        boolean deleted = repository.delete(property1.getPropertyId());
        assertTrue(deleted);
        assertEquals(0, repository.getAll().size());
    }

    @Test
    @Order(11)
    void testDelete_NonExistent() {
        boolean deleted = repository.delete("NonExistent");
        assertFalse(deleted);
    }

    @Test
    @Order(12)
    void testDelete_NullId() {
        boolean deleted = repository.delete(null);
        assertFalse(deleted);
    }

    @Test
    @Order(13)
    void testGetAll() {
        repository.create(property1);
        repository.create(property2);
        List<Property> properties = repository.getAll();
        assertEquals(2, properties.size());
    }

    @Test
    @Order(14)
    void testGetAll_Empty() {
        List<Property> properties = repository.getAll();
        assertEquals(0, properties.size());
    }
}