/* InspectionRepository.java
   Repository for Inspection with Singleton pattern
   Author: Paul Khumalo (230108547)
   Date: 19 March 2026
*/
package za.ac.cput.realestate.repository.impl;

import za.ac.cput.realestate.domain.Inspection;
import za.ac.cput.realestate.repository.IRepository;
import za.ac.cput.realestate.util.Helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InspectionRepository implements IRepository<Inspection, String> {

    private static InspectionRepository repository = null;
    private Map<String, Inspection> inspectionDatabase;

    private InspectionRepository() {
        inspectionDatabase = new HashMap<>();
    }

    public static InspectionRepository getRepository() {
        if (repository == null) {
            repository = new InspectionRepository();
        }
        return repository;
    }

    @Override
    public Inspection create(Inspection inspection) {
        if (Helper.isNullOrEmpty(inspection) || inspectionDatabase.containsKey(inspection.getInspectionId())) {
            return null;
        }
        inspectionDatabase.put(inspection.getInspectionId(), inspection);
        return inspection;
    }

    @Override
    public Inspection read(String inspectionId) {
        if (Helper.isNullOrEmpty(inspectionId)) {
            return null;
        }
        return inspectionDatabase.get(inspectionId);
    }

    @Override
    public Inspection update(Inspection inspection) {
        if (Helper.isNullOrEmpty(inspection) || !inspectionDatabase.containsKey(inspection.getInspectionId())) {
            return null;
        }
        inspectionDatabase.put(inspection.getInspectionId(), inspection);
        return inspection;
    }

    @Override
    public boolean delete(String inspectionId) {
        if (Helper.isNullOrEmpty(inspectionId)) {
            return false;
        }
        return inspectionDatabase.remove(inspectionId) != null;
    }

    @Override
    public List<Inspection> getAll() {
        return new ArrayList<>(inspectionDatabase.values());
    }

    // Additional methods
    public List<Inspection> getInspectionsByProperty(String propertyId) {
        if (Helper.isNullOrEmpty(propertyId)) {
            return new ArrayList<>();
        }
        return inspectionDatabase.values().stream()
                .filter(i -> i.getPropertyId().equals(propertyId))
                .collect(Collectors.toList());
    }

    public List<Inspection> getInspectionsByStatus(String status) {
        if (Helper.isNullOrEmpty(status)) {
            return new ArrayList<>();
        }
        return inspectionDatabase.values().stream()
                .filter(i -> i.getStatus().equals(status))
                .collect(Collectors.toList());
    }
}