/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import org.apache.commons.lang3.StringUtils;
/**
 *
 * @author busrasahin
 */
public class InputValidator {

    // Validates if the ID matches the pattern "S-XXXX"
    public static boolean isValidId(String id) {
        return id.matches("S-\\d{4}");
    }

    // Validates if the GPA is between 0.0 and 4.0
    public static boolean isValidGPA(double gpa) {
        return gpa >= 0.0 && gpa <= 4.0;
    }

    // Uses Apache Commons Lang to check if a string is blank
    public static boolean isBlank(String input) {
        return StringUtils.isBlank(input);
    }
}

