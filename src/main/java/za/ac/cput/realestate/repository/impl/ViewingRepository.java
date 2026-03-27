/* ViewingRepository.java
   Repository for Viewing with Singleton pattern
   Name: Mfanafuthi Khumalo
   Student Number: 230018270
   Date: 20 March 2026
*/
package za.ac.cput.realestate.repository.impl;

import za.ac.cput.realestate.domain.Viewing;
import za.ac.cput.realestate.repository.IRepository;
import za.ac.cput.realestate.util.Helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ViewingRepository implements IRepository<Viewing, String> {

    private static ViewingRepository repository = null;
    private Map<String, Viewing> viewingDatabase;

    private ViewingRepository() {
        viewingDatabase = new HashMap<>();
    }

    public static ViewingRepository getRepository() {
        if (repository == null) {
            repository = new ViewingRepository();
        }
        return repository;
    }

    @Override
    public Viewing create(Viewing viewing) {
        if (Helper.isNullOrEmpty(viewing) || viewingDatabase.containsKey(viewing.getViewingId())) {
            return null;
        }
        viewingDatabase.put(viewing.getViewingId(), viewing);
        return viewing;
    }

    @Override
    public Viewing read(String viewingId) {
        if (Helper.isNullOrEmpty(viewingId)) {
            return null;
        }
        return viewingDatabase.get(viewingId);
    }

    @Override
    public Viewing update(Viewing viewing) {
        if (Helper.isNullOrEmpty(viewing) || !viewingDatabase.containsKey(viewing.getViewingId())) {
            return null;
        }
        viewingDatabase.put(viewing.getViewingId(), viewing);
        return viewing;
    }

    @Override
    public boolean delete(String viewingId) {
        if (Helper.isNullOrEmpty(viewingId)) {
            return false;
        }
        return viewingDatabase.remove(viewingId) != null;
    }

    @Override
    public List<Viewing> getAll() {
        return new ArrayList<>(viewingDatabase.values());
    }

    // Additional methods for specific queries
    public List<Viewing> getViewingsByProperty(String propertyId) {
        if (Helper.isNullOrEmpty(propertyId)) {
            return new ArrayList<>();
        }
        return viewingDatabase.values().stream()
                .filter(v -> v.getPropertyId().equals(propertyId))
                .collect(Collectors.toList());
    }

    public List<Viewing> getViewingsByClient(String clientId) {
        if (Helper.isNullOrEmpty(clientId)) {
            return new ArrayList<>();
        }
        return viewingDatabase.values().stream()
                .filter(v -> v.getClientId().equals(clientId))
                .collect(Collectors.toList());
    }
}