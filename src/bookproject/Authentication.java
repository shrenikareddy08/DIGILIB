package bookproject;

import java.util.ArrayList;
import java.util.Scanner;

public class Authentication {

    private static Scanner sc = new Scanner(System.in);

    public static User currentUser = null;

    public static void startAuthentication() {

        while (true) {

            System.out.println("\n======================================");
            System.out.println("        AUTHENTICATION SYSTEM");
            System.out.println("======================================");

            System.out.println("1. Login");
            System.out.println("2. Signup");
            System.out.println("3. Exit");

            System.out.print("Enter Choice : ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    login();
                    if (currentUser != null) {
                        return;
                    }
                    break;

                case 2:
                    signup();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    public static void signup() {

        System.out.println("\n------ SIGNUP ------");

        System.out.print("User ID : ");
        String userId = sc.nextLine();

        for (User u : FileRetrieve.users) {

            if (u.getUserId().equals(userId)) {

                System.out.println("User ID already exists.");
                return;
            }
        }

        System.out.print("Name : ");
        String name = sc.nextLine();

        String role;

        while (true) {

            System.out.print("Role (Student/Admin) : ");
            role = sc.nextLine();

            if (role.equalsIgnoreCase("Student")
                    || role.equalsIgnoreCase("Admin")) {
                break;
            }

            System.out.println("Invalid Role!");
        }

        User newUser = new User(userId, name, role);

        FileRetrieve.users.add(newUser);
        FileRetrieve.saveUsersToFile();

        System.out.println("Signup Successful!");
    }

    public static void login() {

        System.out.println("\n------ LOGIN ------");

        System.out.print("User ID : ");
        String userId = sc.nextLine().trim();

        System.out.print("Role : ");
        String role = sc.nextLine().trim().toLowerCase(); // ✅ normalize input

        for (User u : FileRetrieve.users) {

            if (u.getUserId().trim().equals(userId)
                    && u.getRole().trim().toLowerCase().equals(role)) {

                currentUser = u;

                System.out.println("\nLogin Successful!");
                System.out.println("Welcome " + u.getName());
                System.out.println("Role : " + u.getRole());

                return;
            }
        }

        System.out.println("Invalid User ID or Role.");
    }
}