package services;

import users.*;

public class AuthService {

    public User login(String role, String email, String password) {

        if (role.equalsIgnoreCase("student")) {
            return new Student(email, password);
        } 
        else if (role.equalsIgnoreCase("professor")) {
            return new Professor(email, password);
        } 
        else if (role.equalsIgnoreCase("admin")) {
            return new Administrator(email, password);
        }

        return null;
    }
}