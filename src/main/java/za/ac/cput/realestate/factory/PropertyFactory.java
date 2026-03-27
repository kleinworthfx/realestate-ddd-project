/*
Property.Java
property model class
Author: Francine Mulangu Kasongo 230978649
25/03/2026
 */

package za.ac.cput.realestate.factory;

import za.ac.cput.realestate.domain.Property;

public class PropertyFactory {
    public static Property createProperty(String propertyId,
                                          String address,
                                          double price,
                                          double kitchen,
                                          double garage,
                                          int bedrooms,
                                          double bathrooms,
                                          String propertyType,
                                          String status) {
        return new Property.Builder()
                .propertyId(propertyId)
                .address(address)
                .price(price)
                .kitchen(kitchen)
                .garage(garage)
                .bedrooms(bedrooms)
                .bathrooms(bathrooms)
                .propertyType(propertyType)
                .status(status)
                .build();
    }

    public static Property  createBasicProperty(String propertyId,
                                                String address,
                                                double price){
        return new Property.Builder()
                .propertyId(propertyId)
                .address(address)
                .price(price)
                .bedrooms(0)
                .garage(0.0)
                .kitchen(0.0)
                .bedrooms(0)
                .bathrooms(0.0)
                .propertyType("Unknown")
                .Status("Available")
                .build();
    }

}
