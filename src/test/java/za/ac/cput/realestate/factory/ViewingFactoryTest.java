/* ViewingFactoryTest.java
   Test class for ViewingFactory
  Name: Mfanafuthi Khumalo
   Student Number: 230018270
   Date: 15 March 2026
*/
package za.ac.cput.realestate.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.realestate.domain.Viewing;
import za.ac.cput.realestate.util.Helper;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ViewingFactoryTest {

    @Test
    void createViewing_Success() {
        LocalDateTime futureDate = LocalDateTime.now().plusDays(1);
        Viewing viewing = ViewingFactory.createViewing(
                "V001", "P001", "C001", "A001",
                futureDate, "Scheduled", "Client interested", 0
        );

        assertNotNull(viewing);
        assertEquals("V001", viewing.getViewingId());
        assertEquals("P001", viewing.getPropertyId());
        assertEquals("C001", viewing.getClientId());
        assertEquals("A001", viewing.getAgentId());
        assertEquals(futureDate, viewing.getViewingDate());
        assertEquals("Scheduled", viewing.getStatus());
    }

    @Test
    void createViewing_Simple() {
        LocalDateTime futureDate = LocalDateTime.now().plusDays(2);
        Viewing viewing = ViewingFactory.createViewing(
                "P001", "C001", "A001", futureDate
        );

        assertNotNull(viewing);
        assertNotNull(viewing.getViewingId());
        assertEquals("P001", viewing.getPropertyId());
        assertEquals("C001", viewing.getClientId());
        assertEquals("A001", viewing.getAgentId());
        assertEquals(futureDate, viewing.getViewingDate());
        assertEquals("Scheduled", viewing.getStatus());
    }

    @Test
    void createViewing_PastDate_ReturnsNull() {
        LocalDateTime pastDate = LocalDateTime.now().minusDays(1);
        Viewing viewing = ViewingFactory.createViewing(
                "V001", "P001", "C001", "A001",
                pastDate, "Scheduled", "", 0
        );
        assertNull(viewing);
    }

    @Test
    void createViewing_InvalidRating_ReturnsNull() {
        LocalDateTime futureDate = LocalDateTime.now().plusDays(1);
        Viewing viewing = ViewingFactory.createViewing(
                "V001", "P001", "C001", "A001",
                futureDate, "Scheduled", "", 6
        );
        assertNull(viewing);
    }

    @Test
    void createViewing_NullPropertyId_ReturnsNull() {
        LocalDateTime futureDate = LocalDateTime.now().plusDays(1);
        Viewing viewing = ViewingFactory.createViewing(
                "V001", null, "C001", "A001",
                futureDate, "Scheduled", "", 0
        );
        assertNull(viewing);
    }
}