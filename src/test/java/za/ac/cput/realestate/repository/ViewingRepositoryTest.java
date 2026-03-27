/* ViewingRepositoryTest.java
   Test class for ViewingRepository
 Name: Mfanafuthi Khumalo
   Student Number: 230018270
   Date: 20 March 2026
*/
package za.ac.cput.realestate.repository.impl;

import org.junit.jupiter.api.*;
import za.ac.cput.realestate.domain.Viewing;
import za.ac.cput.realestate.factory.ViewingFactory;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ViewingRepositoryTest {

    private static ViewingRepository repository;
    private static Viewing viewing1;
    private static Viewing viewing2;

    @BeforeAll
    static void setup() {
        repository = ViewingRepository.getRepository();
        LocalDateTime futureDate1 = LocalDateTime.now().plusDays(1);
        LocalDateTime futureDate2 = LocalDateTime.now().plusDays(2);

        viewing1 = ViewingFactory.createViewing(
                "V001", "P001", "C001", "A001",
                futureDate1, "Scheduled", "", 0
        );
        viewing2 = ViewingFactory.createViewing(
                "V002", "P001", "C002", "A002",
                futureDate2, "Completed", "Great property", 5
        );
    }

    @BeforeEach
    void clearRepository() {
        repository.getAll().clear();
    }

    @Test
    @Order(1)
    void testCreate() {
        Viewing created = repository.create(viewing1);
        assertNotNull(created);
        assertEquals(viewing1.getViewingId(), created.getViewingId());
    }

    @Test
    @Order(2)
    void testCreate_Duplicate() {
        repository.create(viewing1);
        Viewing duplicate = repository.create(viewing1);
        assertNull(duplicate);
    }

    @Test
    @Order(3)
    void testRead() {
        repository.create(viewing1);
        Viewing read = repository.read(viewing1.getViewingId());
        assertNotNull(read);
        assertEquals(viewing1.getViewingId(), read.getViewingId());
    }

    @Test
    @Order(4)
    void testUpdate() {
        repository.create(viewing1);
        Viewing updated = new Viewing.Builder().copy(viewing1)
                .setStatus("Completed")
                .setFeedback("Client liked it")
                .setRating(4)
                .build();
        Viewing result = repository.update(updated);
        assertNotNull(result);
        assertEquals("Completed", result.getStatus());
        assertEquals(4, result.getRating());
    }

    @Test
    @Order(5)
    void testDelete() {
        repository.create(viewing1);
        boolean deleted = repository.delete(viewing1.getViewingId());
        assertTrue(deleted);
    }

    @Test
    @Order(6)
    void testGetAll() {
        repository.create(viewing1);
        repository.create(viewing2);
        List<Viewing> viewings = repository.getAll();
        assertEquals(2, viewings.size());
    }

    @Test
    @Order(7)
    void testGetViewingsByProperty() {
        repository.create(viewing1);
        repository.create(viewing2);
        List<Viewing> propertyViewings = repository.getViewingsByProperty("P001");
        assertEquals(2, propertyViewings.size());
    }
}