package services;

import exceptions.InvalidLoginException;
import users.*;

public class AuthService {

        public User login(String role, String email, String password) throws InvalidLoginException {

        // STUDENT VALIDATION
        if (role.equalsIgnoreCase("student")) {

            if (!email.endsWith("@university.com")) {
                throw new InvalidLoginException("Invalid email format!");
            }

            String studentId = email.split("@")[0];

            if (!studentId.matches("u\\d{2}[a-z]{2}\\d{3}")) {
                throw new InvalidLoginException("Invalid Student ID format!");
            }
        }

        // 🔥 ALL OBJECT CREATION THROUGH FACTORY
        User user = UserFactory.createUser(role, email, password);

        if (user == null) {
            throw new InvalidLoginException("Invalid role!");
        }

        return user;
    }
}