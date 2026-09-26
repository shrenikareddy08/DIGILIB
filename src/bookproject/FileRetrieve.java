package bookproject;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FileRetrieve {

    static Scanner sc = new Scanner(System.in);

    public static ArrayList<Book> books = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<BorrowRecord> borrowRecords = new ArrayList<>();

    static final String USER_FILE = "users.txt";
    static final String BOOK_FILE = "books.txt";
    static final String BORROW_FILE = "borrowrecords.txt";

    // ================= DATE VALIDATION =================
    public static String getValidDate(String prompt) {

        DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.print(prompt + " (yyyy-MM-dd): ");
            String input = sc.nextLine();

            try {
                LocalDate.parse(input, FORMAT);
                return input;
            } catch (DateTimeParseException e) {
                System.out.println("❌ Invalid format! Please enter date as yyyy-MM-dd");
            }
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("        WELCOME TO DIGILIB");
        System.out.println(" Smart Digital Library System");
        System.out.println("======================================");

        enterUsers();
        enterBooks();
        enterBorrowRecords();

        saveUsersToFile();
        saveBooksToFile();
        saveBorrowRecordsToFile();

        displayStoredData();

        System.out.println("\nData Saved Successfully");
    }

    // ================= USERS =================
    public static void enterUsers() {

        System.out.print("\nEnter Number of Users : ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {

            System.out.println("\nUser " + i);

            System.out.print("User ID : ");
            String id = sc.nextLine();

            System.out.print("Name : ");
            String name = sc.nextLine();

            System.out.print("Role (Student/Admin) : ");
            String role = sc.nextLine();

            users.add(new User(id, name, role));
        }
    }

    public static void saveUsersToFile() {

        try (PrintWriter pw = new PrintWriter(new FileWriter(USER_FILE))) {

            for (User u : users) {
                pw.println(u.getUserId() + "," + u.getName() + "," + u.getRole());
            }

        } catch (Exception e) {
            System.out.println("Error Saving Users");
        }
    }

    public static void loadUsersFromFile() {

        users.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(USER_FILE))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] d = line.split(",");
                if (d.length < 3) continue;

                users.add(new User(d[0], d[1], d[2]));
            }

        } catch (Exception e) {
            System.out.println("Users File Not Found");
        }
    }

    // ================= BOOKS =================
    public static void enterBooks() {

        System.out.print("\nEnter Number of Books : ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {

            System.out.println("\nBook " + i);

            System.out.print("Book ID : ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Title : ");
            String title = sc.nextLine();

            System.out.print("Author : ");
            String author = sc.nextLine();

            System.out.print("Genre : ");
            String genre = sc.nextLine();

            System.out.print("Available Copies : ");
            int available = sc.nextInt();

            System.out.print("Total Copies : ");
            int total = sc.nextInt();

            System.out.print("Borrow Count : ");
            int borrowCount = sc.nextInt();

            System.out.print("Rating : ");
            double rating = sc.nextDouble();
            sc.nextLine();

            books.add(new Book(id, title, author, genre,
                    available, total, borrowCount, rating));
        }
    }

    public static void saveBooksToFile() {

        try (PrintWriter pw = new PrintWriter(new FileWriter(BOOK_FILE))) {

            for (Book b : books) {

                pw.println(
                        b.getBookId() + "," +
                        b.getTitle() + "," +
                        b.getAuthor() + "," +
                        b.getGenre() + "," +
                        b.getAvailableCopies() + "," +
                        b.getTotalCopies() + "," +
                        b.getBorrowCount() + "," +
                        b.getRating()
                );
            }

        } catch (Exception e) {
            System.out.println("Error Saving Books");
        }
    }

    public static void loadBooksFromFile() {

        books.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(BOOK_FILE))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] d = line.split(",");
                if (d.length < 8) continue;

                books.add(new Book(
                        Integer.parseInt(d[0]),
                        d[1],
                        d[2],
                        d[3],
                        Integer.parseInt(d[4]),
                        Integer.parseInt(d[5]),
                        Integer.parseInt(d[6]),
                        Double.parseDouble(d[7])
                ));
            }

        } catch (Exception e) {
            System.out.println("Books File Not Found");
        }
    }

    // ================= BORROW RECORDS =================
    public static void enterBorrowRecords() {

        System.out.print("\nEnter Number of Borrow Records : ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {

            System.out.println("\nBorrow Record " + i);

            System.out.print("Borrow ID : ");
            int borrowId = sc.nextInt();

            System.out.print("Book ID : ");
            int bookId = sc.nextInt();
            sc.nextLine();

            System.out.print("User ID : ");
            String userId = sc.nextLine();

            String borrowDate = getValidDate("Borrow Date");
            String dueDate = getValidDate("Due Date");

            System.out.print("Return Date (NA if not returned) : ");
            String returnDate = sc.nextLine();

            String status;

            if (returnDate.equalsIgnoreCase("NA")) {
                returnDate = "NA";
                status = "Borrowed";
            } else {
                returnDate = getValidDate("Return Date");
                status = "Returned";
            }

            borrowRecords.add(new BorrowRecord(
                    borrowId,
                    userId,
                    bookId,
                    borrowDate,
                    dueDate,
                    returnDate,
                    status
            ));
        }
    }

    public static void saveBorrowRecordsToFile() {

        try (PrintWriter pw = new PrintWriter(new FileWriter(BORROW_FILE))) {

            for (BorrowRecord br : borrowRecords) {

                pw.println(
                        br.getBorrowId() + "," +
                        br.getUserId() + "," +
                        br.getBookId() + "," +
                        br.getBorrowDate() + "," +
                        br.getDueDate() + "," +
                        br.getReturnDate() + "," +
                        br.getStatus()
                );
            }

        } catch (Exception e) {
            System.out.println("Error Saving Borrow Records");
        }
    }

    public static void loadBorrowRecordsFromFile() {

        borrowRecords.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(BORROW_FILE))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] d = line.split(",");
                if (d.length < 7) continue;

                borrowRecords.add(new BorrowRecord(
                        Integer.parseInt(d[0]),
                        d[1],
                        Integer.parseInt(d[2]),
                        d[3],
                        d[4],
                        d[5],
                        d[6]
                ));
            }

        } catch (Exception e) {
            System.out.println("Borrow File Not Found");
        }
    }

    // ================= DISPLAY =================
    public static void displayStoredData() {

        System.out.println("\n========== USERS ==========");

        for (User u : users) {
            System.out.println(u);
        }

        System.out.println("\n========== BOOKS ==========");

        for (Book b : books) {
            System.out.println(b);
        }

        System.out.println("\n====== BORROW RECORDS ======");

        for (BorrowRecord br : borrowRecords) {
            System.out.println(br);
        }
    }
}