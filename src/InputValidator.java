/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author busrasahin
 */
// Import Apache Commons Lang library for extra utilities
import org.apache.commons.lang3.StringUtils;

public class InputValidator {

    // Validate if the student ID matches "S-XXXX" format
    public static boolean isValidId(String id) {
        return id.matches("S-\\d{4}");
    }

    // Validate GPA is between 0.0 and 4.0
    public static boolean isValidGPA(double gpa) {
        return gpa >= 0.0 && gpa <= 4.0;
    }

    // Check if a string is blank (uses Apache Commons Lang)
    public static boolean isBlank(String input) {
        return StringUtils.isBlank(input);
    }
}

