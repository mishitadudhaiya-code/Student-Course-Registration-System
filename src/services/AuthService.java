package services;

import users.*;

public class AuthService {

    public User login(String role, String email, String password) {

        if (role.equalsIgnoreCase("student")) {

    // Extract ID from email
    if (!email.endsWith("@university.com")) {
        System.out.println("Invalid email format!");
        return null;
    }

    String studentId = email.split("@")[0];

    // Optional: validate pattern
    if (!studentId.matches("u\\d{2}[a-z]{2}\\d{3}")) {
        System.out.println("Invalid Student ID format!");
        return null;
    }

    return new Student(email, password, studentId);
}
        else if (role.equalsIgnoreCase("professor")) {
            return new Professor(email, password);
        }
        else if (role.equalsIgnoreCase("ta")) {
            return new TA(email, password);
        }
        else if (role.equalsIgnoreCase("admin")) {
            return new Administrator(email, password);
        }

        return null;
    }
}