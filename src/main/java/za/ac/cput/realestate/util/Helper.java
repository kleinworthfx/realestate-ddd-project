/* Helper.java
   Utility class for validation throughout the application
   Author: Paul Khumalo (230108547)
   Date: 10 March 2026
*/
package za.ac.cput.realestate.util;

import java.time.LocalDateTime;
import java.util.UUID;

public class Helper {

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isNullOrEmpty(Object obj) {
        return obj == null;
    }

    public static boolean isPositive(double number) {
        return number > 0;
    }

    public static boolean isPositive(int number) {
        return number > 0;
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static boolean isValidEmail(String email) {
        if (isNullOrEmpty(email)) return false;
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public static boolean isValidPhone(String phone) {
        if (isNullOrEmpty(phone)) return false;
        return phone.matches("\\d{10}");
    }

    public static boolean isFutureDate(LocalDateTime date) {
        if (date == null) return false;
        return date.isAfter(LocalDateTime.now());
    }
}