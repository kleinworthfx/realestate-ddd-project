/*
Property.Java
property model class
Author: Francine Mulangu Kasongo 230978649
25/03/2026
 */
package za.ac.cput.realestate.domain;


public class Property {
    private String propertyId;
    private String address;
    private double price;
    private int bedrooms;
    private double bathrooms;
    private String propertyType;
    private String status;

    private Property(Builder builder) {
        this.propertyId = builder.propertyId;
        this.address = builder.address;
        this.price = builder.price;
        this.bedrooms = builder.bedrooms;
        this.bathrooms = builder.bathrooms;
        this.propertyType = builder.propertyType;
        this.status = builder.status;
    }

    // Getters
    public String getPropertyId() { return propertyId; }
    public String getAddress() { return address; }
    public double getPrice() { return price; }
    public int getBedrooms() { return bedrooms; }
    public double getBathrooms() { return bathrooms; }
    public String getPropertyType() { return propertyType; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return "Property{" +
                "propertyId='" + propertyId + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", bedrooms=" + bedrooms +
                ", bathrooms=" + bathrooms +
                ", propertyType='" + propertyType + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public static class Builder {
        private String propertyId;
        private String address;
        private double price;
        private int bedrooms;
        private double bathrooms;
        private String propertyType;
        private String status;

        public Builder setPropertyId(String propertyId) {
            this.propertyId = propertyId;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setBedrooms(int bedrooms) {
            this.bedrooms = bedrooms;
            return this;
        }

        public Builder setBathrooms(double bathrooms) {
            this.bathrooms = bathrooms;
            return this;
        }

        public Builder setPropertyType(String propertyType) {
            this.propertyType = propertyType;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder copy(Property property) {
            this.propertyId = property.propertyId;
            this.address = property.address;
            this.price = property.price;
            this.bedrooms = property.bedrooms;
            this.bathrooms = property.bathrooms;
            this.propertyType = property.propertyType;
            this.status = property.status;
            return this;
        }

        public Property build() {
            return new Property(this);
        }
    }
}