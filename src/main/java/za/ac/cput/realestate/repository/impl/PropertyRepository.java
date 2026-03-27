/*
Property.Java
property Repository class
Author: Francine Mulangu Kasongo 230978649
26/03/2026
 */
package za.ac.cput.realestate.repository.impl;

import za.ac.cput.realestate.domain.Property;
import za.ac.cput.realestate.repository.IRepository;
import za.ac.cput.realestate.util.Helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertyRepository implements IRepository<Property, String> {

    private static PropertyRepository repository = null;
    private Map<String, Property> propertyDatabase;

    private PropertyRepository() {
        propertyDatabase = new HashMap<>();
    }

    public static PropertyRepository getRepository() {
        if (repository == null) {
            repository = new PropertyRepository();
        }
        return repository;
    }

    @Override
    public Property create(Property property) {
        if (Helper.isNullOrEmpty(property)) {
            return null;
        }
        if (propertyDatabase.containsKey(property.getPropertyId())) {
            return null;
        }
        propertyDatabase.put(property.getPropertyId(), property);
        return property;
    }

    @Override
    public Property read(String propertyId) {
        if (Helper.isNullOrEmpty(propertyId)) {
            return null;
        }
        return propertyDatabase.get(propertyId);
    }

    @Override
    public Property update(Property property) {
        if (Helper.isNullOrEmpty(property)) {
            return null;
        }
        if (!propertyDatabase.containsKey(property.getPropertyId())) {
            return null;
        }
        propertyDatabase.put(property.getPropertyId(), property);
        return property;
    }

    @Override
    public boolean delete(String propertyId) {
        if (Helper.isNullOrEmpty(propertyId)) {
            return false;
        }
        return propertyDatabase.remove(propertyId) != null;
    }

    @Override
    public List<Property> getAll() {
        return new ArrayList<>(propertyDatabase.values());
    }
}