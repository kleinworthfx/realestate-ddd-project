/* Inspection.java
   Inspection model class using Builder Pattern
   Author: Paul Khumalo (230108547)
   Date: 12 March 2026
*/
package za.ac.cput.realestate.domain;

import java.time.LocalDateTime;

public class Inspection {
    private String inspectionId;
    private String propertyId;
    private String inspectorName;
    private LocalDateTime inspectionDate;
    private String report;
    private String status;
    private double cost;

    private Inspection(Builder builder) {
        this.inspectionId = builder.inspectionId;
        this.propertyId = builder.propertyId;
        this.inspectorName = builder.inspectorName;
        this.inspectionDate = builder.inspectionDate;
        this.report = builder.report;
        this.status = builder.status;
        this.cost = builder.cost;
    }

    public String getInspectionId() { return inspectionId; }
    public String getPropertyId() { return propertyId; }
    public String getInspectorName() { return inspectorName; }
    public LocalDateTime getInspectionDate() { return inspectionDate; }
    public String getReport() { return report; }
    public String getStatus() { return status; }
    public double getCost() { return cost; }

    @Override
    public String toString() {
        return "Inspection{" +
                "inspectionId='" + inspectionId + '\'' +
                ", propertyId='" + propertyId + '\'' +
                ", inspectorName='" + inspectorName + '\'' +
                ", inspectionDate=" + inspectionDate +
                ", report='" + report + '\'' +
                ", status='" + status + '\'' +
                ", cost=" + cost +
                '}';
    }

    public static class Builder {
        private String inspectionId;
        private String propertyId;
        private String inspectorName;
        private LocalDateTime inspectionDate;
        private String report;
        private String status;
        private double cost;

        public Builder setInspectionId(String inspectionId) {
            this.inspectionId = inspectionId;
            return this;
        }

        public Builder setPropertyId(String propertyId) {
            this.propertyId = propertyId;
            return this;
        }

        public Builder setInspectorName(String inspectorName) {
            this.inspectorName = inspectorName;
            return this;
        }

        public Builder setInspectionDate(LocalDateTime inspectionDate) {
            this.inspectionDate = inspectionDate;
            return this;
        }

        public Builder setReport(String report) {
            this.report = report;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setCost(double cost) {
            this.cost = cost;
            return this;
        }

        public Builder copy(Inspection inspection) {
            this.inspectionId = inspection.inspectionId;
            this.propertyId = inspection.propertyId;
            this.inspectorName = inspection.inspectorName;
            this.inspectionDate = inspection.inspectionDate;
            this.report = inspection.report;
            this.status = inspection.status;
            this.cost = inspection.cost;
            return this;
        }

        public Inspection build() {
            return new Inspection(this);
        }
    }
}