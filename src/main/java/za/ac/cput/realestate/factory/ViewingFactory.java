/* ViewingFactory.java
   Factory for creating Viewing objects
   Name: Mfanafuthi Khumalo
  Student Number: 230018270
   Date: 15 March 2026
*/
package za.ac.cput.realestate.factory;

import za.ac.cput.realestate.domain.Viewing;
import za.ac.cput.realestate.util.Helper;

import java.time.LocalDateTime;

public class ViewingFactory {

    public static Viewing createViewing(String viewingId, String propertyId,
                                        String clientId, String agentId,
                                        LocalDateTime viewingDate, String status,
                                        String feedback, int rating) {

        if (Helper.isNullOrEmpty(viewingId) ||
                Helper.isNullOrEmpty(propertyId) ||
                Helper.isNullOrEmpty(clientId) ||
                Helper.isNullOrEmpty(agentId) ||
                viewingDate == null ||
                !Helper.isFutureDate(viewingDate) ||
                Helper.isNullOrEmpty(status) ||
                rating < 0 || rating > 5) {
            return null;
        }

        return new Viewing.Builder()
                .setViewingId(viewingId)
                .setPropertyId(propertyId)
                .setClientId(clientId)
                .setAgentId(agentId)
                .setViewingDate(viewingDate)
                .setStatus(status)
                .setFeedback(feedback)
                .setRating(rating)
                .build();
    }

    public static Viewing createViewing(String propertyId, String clientId,
                                        String agentId, LocalDateTime viewingDate) {

        if (Helper.isNullOrEmpty(propertyId) ||
                Helper.isNullOrEmpty(clientId) ||
                Helper.isNullOrEmpty(agentId) ||
                viewingDate == null ||
                !Helper.isFutureDate(viewingDate)) {
            return null;
        }

        String viewingId = Helper.generateId();
        String status = "Scheduled";

        return new Viewing.Builder()
                .setViewingId(viewingId)
                .setPropertyId(propertyId)
                .setClientId(clientId)
                .setAgentId(agentId)
                .setViewingDate(viewingDate)
                .setStatus(status)
                .setFeedback("")
                .setRating(0)
                .build();
    }
}