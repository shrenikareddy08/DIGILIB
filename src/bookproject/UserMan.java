
package bookproject;

import java.util.*;

public class UserMan {

    static Scanner sc = new Scanner(System.in);

    // ================= VIEW PROFILE =================
    public static void viewProfile() {

        System.out.print("Enter User ID: ");
        String userId = sc.next();

        User user = null;

        for (User u : FileRetrieve.users) {
            if (u.getUserId().equals(userId)) {
                user = u;
                break;
            }
        }

        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.println("\n👤 USER PROFILE");
        System.out.println("================================");
        System.out.println(user);
    }

    // ================= BORROW HISTORY (STACK) =================
    public static void borrowHistory() {

        System.out.print("Enter User ID: ");
        String userId = sc.next();

        Stack<BorrowRecord> stack = new Stack<>();

        // load all records of user into stack
        for (BorrowRecord br : FileRetrieve.borrowRecords) {
            if (br.getUserId().equals(userId)) {
                stack.push(br);
            }
        }

        if (stack.isEmpty()) {
            System.out.println("No borrow history found!");
            return;
        }

        System.out.println("\n📚 BORROW HISTORY (LATEST FIRST)");
        System.out.println("================================");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
            System.out.println("--------------------------------");
        }
    }

    // ================= ACTIVE BORROWED BOOKS =================
    public static void activeBorrowedBooks() {

        System.out.print("Enter User ID: ");
        String userId = sc.next();

        System.out.println("\n📌 ACTIVE BORROWED BOOKS");
        System.out.println("================================");

        boolean found = false;

        for (BorrowRecord br : FileRetrieve.borrowRecords) {

            if (br.getUserId().equals(userId)
                    && br.getStatus().equalsIgnoreCase("Borrowed")) {

                System.out.println(br);
                System.out.println("--------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No active borrowed books!");
        }
    }
}