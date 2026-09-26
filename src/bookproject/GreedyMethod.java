
package bookproject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Queue;
import java.util.LinkedList;

public class GreedyMethod {

    // 🔥 Queue = borrow requests
    private static Queue<Integer> borrowQueue = new LinkedList<>();

    // 📥 Add borrow request
    public static void requestBorrow(int bookId) {
        borrowQueue.add(bookId);
        System.out.println("📌 Borrow request placed successfully for Book ID: " + bookId);
        System.out.println("⏳ Added to processing queue...");
    }

    // 🔥 Greedy Processing (highest availability priority first)
    public static void processBorrowRequests(ArrayList<Book> books) {

        if (borrowQueue.isEmpty()) {
            System.out.println("\n⚠ No pending borrow requests in system.");
            return;
        }

        System.out.println("\n📥 PROCESSING BORROW QUEUE (GREEDY SYSTEM)");
        System.out.println("======================================");

        ArrayList<Integer> requests = new ArrayList<>(borrowQueue);
        borrowQueue.clear();

        for (int reqId : requests) {

            Book found = null;

            for (Book b : books) {
                if (b.getBookId() == reqId) {
                    found = b;
                    break;
                }
            }

            System.out.println("\n📌 Processing Book ID: " + reqId);

            if (found == null) {
                System.out.println("❌ Result: Book not found in system");
                continue;
            }

            System.out.println("📖 Title   : " + found.getTitle());
            System.out.println("📦 Available: " + found.getAvailableCopies());

            if (found.getAvailableCopies() > 0) {

                found.setAvailableCopies(found.getAvailableCopies() - 1);
                found.setBorrowCount(found.getBorrowCount() + 1);

                System.out.println("✅ Status   : BORROW SUCCESSFUL");
                System.out.println("📉 Remaining: " + found.getAvailableCopies());

            } else {
                System.out.println("❌ Status   : NOT AVAILABLE");
                System.out.println("⛔ Added to waitlist (future feature)");
            }

            System.out.println("--------------------------------------");
        }

        System.out.println("✔ All requests processed successfully.");
    }

    // 📚 Display available books
    public static void displayAvailable(ArrayList<Book> books) {

        System.out.println("\n📚 AVAILABLE BOOKS");
        System.out.println("======================================");

        for (Book b : books) {

            if (b.getAvailableCopies() > 0) {

                System.out.println("ID: " + b.getBookId());
                System.out.println("Title: " + b.getTitle());
                System.out.println("Author: " + b.getAuthor());
                System.out.println("Available: " + b.getAvailableCopies());
                System.out.println("--------------------------------------");
            }
        }
    }

    // 🔍 Check availability
    public static void checkAvailability(ArrayList<Book> books, int id) {

        for (Book b : books) {

            if (b.getBookId() == id) {

                System.out.println("\n📌 BOOK STATUS");
                System.out.println("Title: " + b.getTitle());
                System.out.println("Available Copies: " + b.getAvailableCopies());

                if (b.getAvailableCopies() > 0) {
                    System.out.println("✅ Available for Borrow");
                } else {
                    System.out.println("❌ Not Available");
                }
                return;
            }
        }

        System.out.println("❌ Book Not Found");
    }

    // 🔁 Return book
    public static void returnBook(ArrayList<Book> books, int id) {

        LocalDate today = LocalDate.now();

        for (Book b : books) {

            if (b.getBookId() == id) {

                b.setAvailableCopies(b.getAvailableCopies() + 1);

                for (BorrowRecord br : FileRetrieve.borrowRecords) {

                    if (br.getBookId() == id && br.getReturnDate().equals("NA")) {

                        br.setReturnDate(today.toString());

                        LocalDate due = LocalDate.parse(br.getDueDate());
                        LocalDate actual = today;

                        System.out.println("\n🔁 BOOK RETURN DETAILS");
                        System.out.println("======================================");
                        System.out.println("Book Title   : " + b.getTitle());
                        System.out.println("Borrow Date  : " + br.getBorrowDate());
                        System.out.println("Due Date     : " + br.getDueDate());
                        System.out.println("Return Date  : " + actual);

                        // 📌 STATUS LOGIC
                        if (actual.isAfter(due)) {
                            br.setStatus("Returned Late ⚠");
                            System.out.println("Status       : Returned Late ⚠");
                        } else {
                            br.setStatus("Returned On Time ✔");
                            System.out.println("Status       : Returned On Time ✔");
                        }

                        return;
                    }
                }

                System.out.println("⚠ No active borrow record found");
                return;
            }
        }

        System.out.println("❌ Invalid Book ID");
    }
}