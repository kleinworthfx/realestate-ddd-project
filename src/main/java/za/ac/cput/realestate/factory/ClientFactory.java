/* Client.java
   Client model class using Builder Pattern
   Author: Khonzinkosi Khumalo (230231802)
   Date: 18 March 2026
*/
package za.ac.cput.realestate.factory;
import za.ac.cput.realestate.domain.Client;
import za.ac.cput.realestate.util.Helper;

public class ClientFactory {

    public static Client createClient(String clientId, String firstName, String lastName,
                                      String phone, String email, double budget,
                                      String preferredType) {

        if (Helper.isNullOrEmpty(clientId) ||
                Helper.isNullOrEmpty(firstName) ||
                Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(phone) ||
                Helper.isNullOrEmpty(email) ||
                !Helper.isPositive(budget) ||
                Helper.isNullOrEmpty(preferredType)) {
            return null;
        }

        return new Client.Builder()
                .setClientId(clientId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhone(phone)
                .setEmail(email)
                .setBudget(budget)
                .setPreferredType(preferredType)
                .build();
    }

    public static Client createClient(String firstName, String lastName, String phone,
                                      String email, double budget, String preferredType) {

        if (Helper.isNullOrEmpty(firstName) ||
                Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(phone) ||
                Helper.isNullOrEmpty(email) ||
                !Helper.isPositive(budget) ||
                Helper.isNullOrEmpty(preferredType)) {
            return null;
        }

        String clientId = Helper.generateId();

        return new Client.Builder()
                .setClientId(clientId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhone(phone)
                .setEmail(email)
                .setBudget(budget)
                .setPreferredType(preferredType)
                .build();
    }
}
