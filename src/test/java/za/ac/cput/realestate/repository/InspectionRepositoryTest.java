/* InspectionRepositoryTest.java
   Test class for InspectionRepository
   Author: Paul Khumalo (230108547)
   Date: 20 March 2026
*/
package za.ac.cput.realestate.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.realestate.domain.Inspection;
import za.ac.cput.realestate.factory.InspectionFactory;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InspectionRepositoryTest {

    private static za.ac.cput.realestate.repository.impl.InspectionRepository repository;
    private static Inspection inspection1;
    private static Inspection inspection2;

    @BeforeAll
    static void setup() {
        repository = za.ac.cput.realestate.repository.impl.InspectionRepository.getRepository();
        LocalDateTime futureDate1 = LocalDateTime.now().plusDays(1);
        LocalDateTime futureDate2 = LocalDateTime.now().plusDays(2);

        inspection1 = InspectionFactory.createInspection(
                "I001", "P001", "Bob Inspector", futureDate1,
                "", "Scheduled", 500.00
        );
        inspection2 = InspectionFactory.createInspection(
                "I002", "P002", "Alice Inspector", futureDate2,
                "Minor issues found", "Completed", 600.00
        );
    }

    @BeforeEach
    void clearRepository() {
        repository.getAll().clear();
    }

    @Test
    @Order(1)
    void testCreate() {
        Inspection created = repository.create(inspection1);
        assertNotNull(created);
        assertEquals(inspection1.getInspectionId(), created.getInspectionId());
    }

    @Test
    @Order(2)
    void testCreate_Duplicate() {
        repository.create(inspection1);
        Inspection duplicate = repository.create(inspection1);
        assertNull(duplicate);
    }

    @Test
    @Order(3)
    void testRead() {
        repository.create(inspection1);
        Inspection read = repository.read(inspection1.getInspectionId());
        assertNotNull(read);
        assertEquals(inspection1.getInspectionId(), read.getInspectionId());
    }

    @Test
    @Order(4)
    void testUpdate() {
        repository.create(inspection1);
        Inspection updated = new Inspection.Builder().copy(inspection1)
                .setStatus("Completed")
                .setReport("All good")
                .build();
        Inspection result = repository.update(updated);
        assertNotNull(result);
        assertEquals("Completed", result.getStatus());
        assertEquals("All good", result.getReport());
    }

    @Test
    @Order(5)
    void testDelete() {
        repository.create(inspection1);
        boolean deleted = repository.delete(inspection1.getInspectionId());
        assertTrue(deleted);
    }

    @Test
    @Order(6)
    void testGetAll() {
        repository.create(inspection1);
        repository.create(inspection2);
        List<Inspection> inspections = repository.getAll();
        assertEquals(2, inspections.size());
    }

    @Test
    @Order(7)
    void testGetInspectionsByProperty() {
        repository.create(inspection1);
        repository.create(inspection2);
        List<Inspection> propertyInspections = repository.getInspectionsByProperty("P001");
        assertEquals(1, propertyInspections.size());
    }

    @Test
    @Order(8)
    void testGetInspectionsByStatus() {
        repository.create(inspection1);
        repository.create(inspection2);
        List<Inspection> scheduled = repository.getInspectionsByStatus("Scheduled");
        assertEquals(1, scheduled.size());
    }
}