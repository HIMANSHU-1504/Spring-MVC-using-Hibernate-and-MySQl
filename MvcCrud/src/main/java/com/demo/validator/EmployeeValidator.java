package com.demo.validator;

import com.demo.model.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeValidator {
    public static List<String> getMissingFields(Employee emp) {
        List<String> missingFields = new ArrayList<>();

        if (!isValidName(emp.getName())) {
            missingFields.add("Name");
        }

        if (!isValidEmail(emp.getEmail())) {
            missingFields.add("Email");
        }

        if (!isValidPassword(emp.getPassword())) {
            missingFields.add("Password");
        }

        if (!isValidGender(emp.getGender())) {
            missingFields.add("Gender");
        }

        if (!isValidMobile(emp.getMobile())) {
            missingFields.add("Mobile");
        }

        return missingFields;
    }

    private static boolean isValidGender(String gender) {
        return gender != null;
    }

    private static boolean isValidMobile(String mobile) {
        return mobile != null && !mobile.trim().isEmpty() && mobile.length() == 10;
    }

    private static boolean isValidPassword(String password) {
        return password != null && !password.trim().isEmpty() && password.length() >= 6;
    }

    private static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    private static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
