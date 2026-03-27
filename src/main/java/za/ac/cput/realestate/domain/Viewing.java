/* Viewing.java
   Viewing model class using Builder Pattern
   Name: Mfanafuthi khumalo
  Student Number:230018270
   Date: 12 March 2026
*/
package za.ac.cput.realestate.domain;

import java.time.LocalDateTime;

public class Viewing {
    private String viewingId;
    private String propertyId;
    private String clientId;
    private String agentId;
    private LocalDateTime viewingDate;
    private String status;
    private String feedback;
    private int rating;

    private Viewing(Builder builder) {
        this.viewingId = builder.viewingId;
        this.propertyId = builder.propertyId;
        this.clientId = builder.clientId;
        this.agentId = builder.agentId;
        this.viewingDate = builder.viewingDate;
        this.status = builder.status;
        this.feedback = builder.feedback;
        this.rating = builder.rating;
    }

    public String getViewingId() { return viewingId; }
    public String getPropertyId() { return propertyId; }
    public String getClientId() { return clientId; }
    public String getAgentId() { return agentId; }
    public LocalDateTime getViewingDate() { return viewingDate; }
    public String getStatus() { return status; }
    public String getFeedback() { return feedback; }
    public int getRating() { return rating; }

    @Override
    public String toString() {
        return "Viewing{" +
                "viewingId='" + viewingId + '\'' +
                ", propertyId='" + propertyId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", agentId='" + agentId + '\'' +
                ", viewingDate=" + viewingDate +
                ", status='" + status + '\'' +
                ", feedback='" + feedback + '\'' +
                ", rating=" + rating +
                '}';
    }

    public static class Builder {
        private String viewingId;
        private String propertyId;
        private String clientId;
        private String agentId;
        private LocalDateTime viewingDate;
        private String status;
        private String feedback;
        private int rating;

        public Builder setViewingId(String viewingId) {
            this.viewingId = viewingId;
            return this;
        }

        public Builder setPropertyId(String propertyId) {
            this.propertyId = propertyId;
            return this;
        }

        public Builder setClientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder setAgentId(String agentId) {
            this.agentId = agentId;
            return this;
        }

        public Builder setViewingDate(LocalDateTime viewingDate) {
            this.viewingDate = viewingDate;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setFeedback(String feedback) {
            this.feedback = feedback;
            return this;
        }

        public Builder setRating(int rating) {
            this.rating = rating;
            return this;
        }

        public Builder copy(Viewing viewing) {
            this.viewingId = viewing.viewingId;
            this.propertyId = viewing.propertyId;
            this.clientId = viewing.clientId;
            this.agentId = viewing.agentId;
            this.viewingDate = viewing.viewingDate;
            this.status = viewing.status;
            this.feedback = viewing.feedback;
            this.rating = viewing.rating;
            return this;
        }

        public Viewing build() {
            return new Viewing(this);
        }
    }
}
