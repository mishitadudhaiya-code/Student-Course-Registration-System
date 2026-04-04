package main;

import java.util.Scanner;
import services.AuthService;
import users.User;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AuthService auth = new AuthService();

        while (true) {

            System.out.println("\nWelcome to Course System");
            System.out.println("1. Login");
            System.out.println("2. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (choice == 1) {

                System.out.print("Enter role (student/professor/admin/ta): ");
                String role = sc.nextLine();

                System.out.print("Enter email: ");
                String email = sc.nextLine();

                System.out.print("Enter password: ");
                String password = sc.nextLine();

                User user = auth.login(role, email, password);

                if (user != null) {
                    user.showMenu(); // after exit → comes back here
                } else {
                    System.out.println("Invalid login");
                }

            } else {
                System.out.println("Exiting system...");
                break;
            }
        }

        sc.close();
    }
}