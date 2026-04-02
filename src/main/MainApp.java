package main;

import java.util.Scanner;
import services.AuthService;
import users.User;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AuthService auth = new AuthService();

        System.out.println("Welcome to Course System");

        System.out.print("Enter role (student/professor/admin): ");
        String role = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        User user = auth.login(role, email, password);

        if (user != null) {
            user.showMenu();
        } else {
            System.out.println("Invalid login");
        }

        sc.close();
    }
}