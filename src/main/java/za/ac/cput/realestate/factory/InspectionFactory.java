/* InspectionFactory.java
   Factory for creating Inspection objects
   Author: Team Lead (230108547)
   Date: 15 March 2026
*/
package za.ac.cput.realestate.factory;

import za.ac.cput.realestate.domain.Inspection;
import za.ac.cput.realestate.util.Helper;

import java.time.LocalDateTime;

public class InspectionFactory {

    public static Inspection createInspection(String inspectionId, String propertyId,
                                              String inspectorName, LocalDateTime inspectionDate,
                                              String report, String status, double cost) {

        if (Helper.isNullOrEmpty(inspectionId) ||
                Helper.isNullOrEmpty(propertyId) ||
                Helper.isNullOrEmpty(inspectorName) ||
                inspectionDate == null ||
                !Helper.isFutureDate(inspectionDate) ||
                Helper.isNullOrEmpty(status) ||
                !Helper.isPositive(cost)) {
            return null;
        }

        return new Inspection.Builder()
                .setInspectionId(inspectionId)
                .setPropertyId(propertyId)
                .setInspectorName(inspectorName)
                .setInspectionDate(inspectionDate)
                .setReport(report)
                .setStatus(status)
                .setCost(cost)
                .build();
    }

    public static Inspection createInspection(String propertyId, String inspectorName,
                                              LocalDateTime inspectionDate, double cost) {

        if (Helper.isNullOrEmpty(propertyId) ||
                Helper.isNullOrEmpty(inspectorName) ||
                inspectionDate == null ||
                !Helper.isFutureDate(inspectionDate) ||
                !Helper.isPositive(cost)) {
            return null;
        }

        String inspectionId = Helper.generateId();
        String status = "Scheduled";
        String report = "";

        return new Inspection.Builder()
                .setInspectionId(inspectionId)
                .setPropertyId(propertyId)
                .setInspectorName(inspectorName)
                .setInspectionDate(inspectionDate)
                .setReport(report)
                .setStatus(status)
                .setCost(cost)
                .build();
    }
}