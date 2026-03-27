/*
Property.Java
property model class
Author: Francine Mulangu Kasongo 230978649
25/03/2026
 */

package za.ac.cput.realestate.factory;

import za.ac.cput.realestate.domain.Property;
import za.ac.cput.realestate.util.Helper;

public class PropertyFactory {

    public static Property createProperty(String propertyId, String address,
                                          double price, int bedrooms,
                                          double bathrooms, String propertyType,
                                          String status) {

        if (Helper.isNullOrEmpty(propertyId) ||
                Helper.isNullOrEmpty(address) ||
                !Helper.isPositive(price) ||
                !Helper.isPositive(bedrooms) ||
                !Helper.isPositive(bathrooms) ||
                Helper.isNullOrEmpty(propertyType) ||
                Helper.isNullOrEmpty(status)) {
            return null;
        }

        return new Property.Builder()
                .setPropertyId(propertyId)
                .setAddress(address)
                .setPrice(price)
                .setBedrooms(bedrooms)
                .setBathrooms(bathrooms)
                .setPropertyType(propertyType)
                .setStatus(status)
                .build();
    }

    public static Property createProperty(String address, double price,
                                          int bedrooms, double bathrooms,
                                          String propertyType, String status) {

        if (Helper.isNullOrEmpty(address) ||
                !Helper.isPositive(price) ||
                !Helper.isPositive(bedrooms) ||
                !Helper.isPositive(bathrooms) ||
                Helper.isNullOrEmpty(propertyType) ||
                Helper.isNullOrEmpty(status)) {
            return null;
        }

        String propertyId = Helper.generateId();

        return new Property.Builder()
                .setPropertyId(propertyId)
                .setAddress(address)
                .setPrice(price)
                .setBedrooms(bedrooms)
                .setBathrooms(bathrooms)
                .setPropertyType(propertyType)
                .setStatus(status)
                .build();
    }
}