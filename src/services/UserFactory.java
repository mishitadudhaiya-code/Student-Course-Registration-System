package services;

import users.*;

public class UserFactory {

    public static User createUser(String role, String email, String password) {

        if (role.equalsIgnoreCase("student")) {
            String studentId = email.split("@")[0];
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