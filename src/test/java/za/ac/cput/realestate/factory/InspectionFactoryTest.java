/* InspectionFactoryTest.java
   Test class for InspectionFactory
   Author: Paul Khumalo (230108547)
   Date: 16 March 2026
*/
package za.ac.cput.realestate.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.realestate.domain.Inspection;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class InspectionFactoryTest {

    @Test
    void createInspection_Success() {
        LocalDateTime futureDate = LocalDateTime.now().plusDays(3);
        Inspection inspection = za.ac.cput.realestate.factory.InspectionFactory.createInspection(
                "I001", "P001", "Bob Inspector", futureDate,
                "All good", "Completed", 500.00
        );

        assertNotNull(inspection);
        assertEquals("I001", inspection.getInspectionId());
        assertEquals("P001", inspection.getPropertyId());
        assertEquals("Bob Inspector", inspection.getInspectorName());
        assertEquals(futureDate, inspection.getInspectionDate());
        assertEquals("All good", inspection.getReport());
        assertEquals("Completed", inspection.getStatus());
        assertEquals(500.00, inspection.getCost());
    }

    @Test
    void createInspection_Simple() {
        LocalDateTime futureDate = LocalDateTime.now().plusDays(5);
        Inspection inspection = za.ac.cput.realestate.factory.InspectionFactory.createInspection(
                "P001", "Bob Inspector", futureDate, 500.00
        );

        assertNotNull(inspection);
        assertNotNull(inspection.getInspectionId());
        assertEquals("P001", inspection.getPropertyId());
        assertEquals("Bob Inspector", inspection.getInspectorName());
        assertEquals(futureDate, inspection.getInspectionDate());
        assertEquals("Scheduled", inspection.getStatus());
        assertEquals(500.00, inspection.getCost());
    }

    @Test
    void createInspection_PastDate_ReturnsNull() {
        LocalDateTime pastDate = LocalDateTime.now().minusDays(1);
        Inspection inspection = za.ac.cput.realestate.factory.InspectionFactory.createInspection(
                "I001", "P001", "Bob Inspector", pastDate,
                "", "Scheduled", 500.00
        );
        assertNull(inspection);
    }

    @Test
    void createInspection_NegativeCost_ReturnsNull() {
        LocalDateTime futureDate = LocalDateTime.now().plusDays(3);
        Inspection inspection = za.ac.cput.realestate.factory.InspectionFactory.createInspection(
                "I001", "P001", "Bob Inspector", futureDate,
                "", "Scheduled", -100.00
        );
        assertNull(inspection);
    }

    @Test
    void createInspection_NullPropertyId_ReturnsNull() {
        LocalDateTime futureDate = LocalDateTime.now().plusDays(3);
        Inspection inspection = za.ac.cput.realestate.factory.InspectionFactory.createInspection(
                "I001", null, "Bob Inspector", futureDate,
                "", "Scheduled", 500.00
        );
        assertNull(inspection);
    }
}