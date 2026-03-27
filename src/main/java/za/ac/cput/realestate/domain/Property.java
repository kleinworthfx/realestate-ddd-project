/*
Property.Java
property model class
Author: Francine Mulangu Kasongo 230978649
25/03/2026
 */
package za.ac.cput.realestate.domain;


public class Property {


    private double price;
    private String propertyId;
    private String address;
    private String propertyType;
    private String status;
    private int bedrooms;
    public double kitchen;
    private double bathrooms;
    private double garage;


    private Property(Client.Builder builder) {
        this.propertyId = builder.propertyId;
        this.address = builder.address;
        this.bedrooms = builder.bedrooms;
        this.bathrooms = builder.bathrooms;
        this.propertyType = builder.propertyType;
        this.status = builder.status;
        this.kitchen = builder.kitchen;
        this.garage = builder.garage;
        this.price = builder.price;
    }

    public Property(Builder builder) {
    }

    public String getPropertyID() {
        return propertyId;
    }

    public String getAddress() {
        return address;
    }

    public double getPrice() {
        return price;
    }

    public double getGarage() {
        return garage;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public double getBathrooms() {
        return bathrooms;
    }

    public double getKitchen() {
        return kitchen;
    }

    public String getStatus() {
        return status;
    }

    public Builder kitchen(double v) {
        return null;
    }

    public String getPropertyId() {
        return null;
    }

    public static class Builder {
        private String propertyId;
        private String address;
        private double price;
        private int bedrooms;
        private double bathrooms;
        private String propertyType;
        private String status;
        private double kitchen;
        public String garage;

        public Builder propertyId(String propertyId) {
            this.propertyId = propertyId;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder bedrooms(int bedrooms) {
            this.bedrooms = bedrooms;
            return this;
        }

        public Builder propertyType(String propertyType) {
            this.propertyType = propertyType;
            return this;
        }

        public Builder bathrooms(double bathrooms) {
            this.bathrooms = bathrooms;
            return this;
        }

        public Builder Status(String status) {
            this.status = status;
            return this;
        }

        public Builder bedrooms(double bathrooms) {
            this.bathrooms = bathrooms;
            return this;
        }

        public Builder kitchen(double kitchen) {
            this.kitchen = kitchen;
            return this;
        }

        public Builder gargage(String garage) {
            this.garage = garage;
            return this;
        }

        public Property build() {
            if (propertyId == null || propertyId.isEmpty()) {
                throw new IllegalArgumentException("PROPERTY ID IS NEEDED");

            }
            if (address == null || address.isEmpty()) {
                throw new IllegalArgumentException("ADDRESS IS NEEDED");
            }
            if (price <= 0) {
                throw new IllegalArgumentException("PRICE MUST BE GREATER THAN ZERO");
            }
            return new Property(this);
        }

        public Property garage(double v) {
            this.garage =garage;
            return this.build();
        }
    }

    @Override
    public String toString() {
        return "Property {" +
                "propertyId=" + propertyId + '/' + ", address= " + address + '/' + ", price = " + price + ", bedrooms=" + bedrooms + ",Kitchen" + kitchen + ", garage" + garage + ", propertyType=" + propertyType + '/' + ", status=" + status + '/' + '}';


    }


    }






