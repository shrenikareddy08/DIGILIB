package bookproject;

import java.util.Scanner;
import java.util.List;
import java.util.Map;

public class MainM {

    static Scanner sc = new Scanner(System.in);
    static BinarySearchTree bst = new BinarySearchTree();

    public static void main(String[] args) {

        System.out.println("\n======================================");
        System.out.println("        WELCOME TO DIGILIB");
        System.out.println("   Smart Library Management System");
        System.out.println("======================================\n");

        FileRetrieve.loadUsersFromFile();
        FileRetrieve.loadBooksFromFile();
        FileRetrieve.loadBorrowRecordsFromFile();

        for (Book b : FileRetrieve.books) {
            bst.insert(b);
        }

        while (true) {

            Authentication.startAuthentication();

            User currentUser = Authentication.currentUser;

            System.out.println("\n======================================");
            System.out.println("       LOGIN SUCCESSFUL");
            System.out.println("======================================");
            System.out.println("Welcome : " + currentUser.getName());
            System.out.println("Role    : " + currentUser.getRole());
            System.out.println("======================================\n");

            if (currentUser.getRole().equalsIgnoreCase("Admin")) {
                adminMenu();
            } else {
                studentMenu();
            }
        }
    }

    // ================= ADMIN MENU =================
    public static void adminMenu() {

        int choice;

        do {
            System.out.println("\n========== ADMIN DASHBOARD ==========");
            System.out.println("1. Book Management");
            System.out.println("2. Book Organization");
            System.out.println("3. Analytics Dashboard");
            System.out.println("4. User Management");
            System.out.println("5. Logout");
            System.out.println("====================================");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    bookManagementMenu();
                    break;

                case 2:
                    bookOrganizationMenu();
                    break;

                case 3:
                    analyticsDashboard();
                    break;

                case 4:
                    userManagementMenu();
                    break;

                case 5:
                    System.out.println("Logging out...");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (true);
    }
    
    public static void userManagementMenu() {

        int choice;

        do {
            System.out.println("\n======================================");
            System.out.println("         USER MANAGEMENT");
            System.out.println("======================================");
            System.out.println("1. View Profile by ID");
            System.out.println("2. View Borrow History");
            System.out.println("3. View Active Borrowed Books");
            System.out.println("4. Back");
            System.out.println("======================================");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    UserMan.viewProfile();
                    break;

                case 2:
                    UserMan.borrowHistory();
                    break;

                case 3:
                    UserMan.activeBorrowedBooks();
                    break;

                case 4:
                    return; // 🔥 back to admin

                default:
                    System.out.println("Invalid Choice");
            }

        } while (true);
    }

    // ================= STUDENT MENU =================
    public static void studentMenu() {
    	
    	

        int choice;

        do {
            System.out.println("\n========== STUDENT DASHBOARD ==========");
            System.out.println("1. 🔎 Book Search ");
            System.out.println("2. 🔃 Book Organization");
            System.out.println("3. 📥 Borrowing Services (Greedy + Queue)");
            System.out.println("4. ⭐ Recommendation Engine (DP + BFS + DFS)");
            System.out.println("5. 📊 Analytics Dashboard");
            System.out.println("6. 🛣️ Smart Reading Paths");
            System.out.println("7. 👤 User Management");
            System.out.println("8. Logout");
            System.out.println("=======================================");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    bookSearch();
                    break;

                case 2:
                    bookOrganizationMenu();
                    break;

                case 3:
                    borrowingServices();
                    break;

                case 4:
                    recommendationEngine();
                    break;

                case 5:
                    analyticsDashboard();
                    break;

                case 6:
                    smartReadingPaths();
                    break;

                case 7:
                   userManagementMenu();
                    break;

                case 8:
                    System.out.println("Logging out...");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (true);
    }
    
    // ================= BOOK SEARCH =================
    public static void bookSearch() {

        System.out.print("\nEnter Book ID : ");
        int id = sc.nextInt();

        Book b = BSearch.searchById(FileRetrieve.books, id);

        if (b != null) {

            System.out.println("\n📚 BOOK FOUND");
            System.out.println("======================================");
            System.out.println("ID       : " + b.getBookId());
            System.out.println("Title    : " + b.getTitle());
            System.out.println("Author   : " + b.getAuthor());
            System.out.println("Genre    : " + b.getGenre());
            System.out.println("Avail    : " + b.getAvailableCopies());
            System.out.println("Total    : " + b.getTotalCopies());
            System.out.println("Borrowed : " + b.getBorrowCount());
            System.out.println("Rating   : " + b.getRating());
            System.out.println("======================================");

        } else {
            System.out.println("❌ Book Not Found");
        }
    }

    
    public static void bookManagementMenu() {

        int choice;

        do {
            System.out.println("\n======================================");
            System.out.println("        BOOK MANAGEMENT");
            System.out.println("======================================");
            System.out.println("1. Add Book");
            System.out.println("2. Delete Book");
            System.out.println("3. Update Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Back");
            System.out.println("======================================");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    deleteBook();
                    break;

                case 3:
                    updateBook();
                    break;

                case 4:
                    bst.displayBooks();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (true);
    }
    public static void addBook() {

        sc.nextLine();

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

        Book book = new Book(id, title, author, genre,
                available, total, borrowCount, rating);

        FileRetrieve.books.add(book);
        bst.insert(book);

        System.out.println("Book Added Successfully.");
    }

    // ================= DELETE BOOK =================
    public static void deleteBook() {

        System.out.print("Enter Book ID : ");
        int id = sc.nextInt();

        Book book = bst.search(id);

        if (book == null) {
            System.out.println("No such book found");
            return;
        }

        bst.delete(id);
        FileRetrieve.books.removeIf(b -> b.getBookId() == id);

        System.out.println("Book Deleted Successfully.");
    }

    // ================= UPDATE BOOK =================
    public static void updateBook() {

        System.out.print("Enter Book ID : ");
        int id = sc.nextInt();

        Book book = bst.search(id);

        if (book == null) {
            System.out.println("Book Not Found");
            return;
        }

        System.out.print("Enter New Borrow Count : ");
        int newCount = sc.nextInt();

        for (int i = 0; i < FileRetrieve.books.size(); i++) {

            if (FileRetrieve.books.get(i).getBookId() == id) {

                Book old = FileRetrieve.books.get(i);

                Book updated = new Book(
                        old.getBookId(),
                        old.getTitle(),
                        old.getAuthor(),
                        old.getGenre(),
                        old.getAvailableCopies(),
                        old.getTotalCopies(),
                        newCount,
                        old.getRating()
                );

                FileRetrieve.books.set(i, updated);
                break;
            }
        }

        bst = new BinarySearchTree();
        for (Book b : FileRetrieve.books) {
            bst.insert(b);
        }

        System.out.println("Book Updated Successfully");
    }

    // ================= BORROWING SERVICES =================
    public static void borrowingServices() {

        int choice;

        do {
            System.out.println("\n📥 BORROWING SERVICES");
            System.out.println("======================================");
            System.out.println("1. Display Available Books");
            System.out.println("2. Borrow Request");
            System.out.println("3. Check Availability");
            System.out.println("4. Process Queue (Greedy)");
            System.out.println("5. Return Book");
            System.out.println("6. Back");
            System.out.println("======================================");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    GreedyMethod.displayAvailable(FileRetrieve.books);
                    break;

                case 2:
                    System.out.print("Book ID: ");
                    int id = sc.nextInt();
                    GreedyMethod.requestBorrow(id);
                    break;

                case 3:
                    System.out.print("Book ID: ");
                    int cid = sc.nextInt();
                    GreedyMethod.checkAvailability(FileRetrieve.books, cid);
                    break;

                case 4:
                    GreedyMethod.processBorrowRequests(FileRetrieve.books);
                    break;

                case 5:
                    System.out.print("Book ID: ");
                    int rid = sc.nextInt();
                    GreedyMethod.returnBook(FileRetrieve.books, rid);
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (true);
    }

    public static void recommendationEngine() {

        int choice;

        do {
            System.out.println("\n⭐ RECOMMENDATION ENGINE");
            System.out.println("======================================");
            System.out.println("1. Popular Books");
            System.out.println("2. Same Author Books");
            System.out.println("3. Same Genre Books");
            System.out.println("4. Back");
            System.out.println("======================================");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // ================= POPULAR BOOKS =================
                case 1: {
                    System.out.println("\n🔥 POPULAR BOOKS:");

                    List<Book> res = DynamicProg.recommendPopular(FileRetrieve.books);

                    if (res == null || res.isEmpty()) {
                        System.out.println("❌ No books available in system");
                        break;
                    }

                    int i = 1;
                    for (Book b : res) {
                        System.out.println(i++ + ". " +
                                b.getTitle() +
                                " | Borrowed: " + b.getBorrowCount() +
                                " | Rating: " + b.getRating());
                    }
                    break;
                }

                // ================= AUTHOR SEARCH =================
                case 2: {
                    System.out.print("\nEnter Author: ");
                    String author = sc.nextLine().trim().toLowerCase();

                    List<Book> res = DynamicProg.bfsAuthor(FileRetrieve.books, author);

                    System.out.println("\n📚 Author Books:");

                    if (res == null || res.isEmpty()) {
                        System.out.println("❌ No books found for author: " + author);
                        break;
                    }

                    int i = 1;
                    for (Book b : res) {
                        System.out.println(i++ + ". " + b.getTitle());
                    }
                    break;
                }

                // ================= GENRE SEARCH =================
                case 3: {
                    System.out.print("\nEnter Genre: ");
                    String genre = sc.nextLine().trim().toLowerCase();

                    List<Book> res = DynamicProg.dfsGenre(FileRetrieve.books, genre);

                    System.out.println("\n📖 Genre Books:");

                    if (res == null || res.isEmpty()) {
                        System.out.println("❌ No books found for genre: " + genre);
                        break;
                    }

                     int i = 1;
                    for (Book b : res) {
                        System.out.println(i++ + ". " + b.getTitle());
                    }
                    break;
                }

                case 4:
                    System.out.println("Returning to dashboard...");
                    return;

                default:
                    System.out.println("❌ Invalid Choice");
            }

        } while (true);
    }

    // ================= ANALYTICS DASHBOARD =================
    public static void analyticsDashboard() {

        int choice;

        do {
            System.out.println("\n======================================");
            System.out.println("        ANALYTICS DASHBOARD");
            System.out.println("======================================");
            System.out.println("1. Most Borrowed Book");
            System.out.println("2. Borrow Trends");
            System.out.println("3. Trending Authors");
            System.out.println("4. Back");
            System.out.println("======================================");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            switch (choice) {

                case 1: {

                    int[] arr = new int[FileRetrieve.books.size()];

                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = FileRetrieve.books.get(i).getBorrowCount();
                    }

                    SegTree st = new SegTree(arr);
                    int maxBorrow = st.getMostPopularBookBorrowCount();

                    System.out.println("\n📊 MOST BORROWED BOOK");
                    System.out.println("======================================");

                    for (Book b : FileRetrieve.books) {
                        if (b.getBorrowCount() == maxBorrow) {
                            System.out.println("Book ID   : " + b.getBookId());
                            System.out.println("Title     : " + b.getTitle());
                            System.out.println("Genre     : " + b.getGenre());
                            System.out.println("Borrows   : " + b.getBorrowCount());
                            System.out.println("--------------------------------------");
                        }
                    }
                    break;
                }

                case 2: {

                    int n = FileRetrieve.books.size();
                    FenTree ft = new FenTree(n);

                    for (int i = 0; i < n; i++) {
                        ft.update(i, FileRetrieve.books.get(i).getBorrowCount());
                    }

                    System.out.println("\n📊 BORROW TRENDS");
                    System.out.println("======================================");

                    int total = ft.query(n - 1);

                    for (int i = 0; i < n; i++) {
                        System.out.println(
                                FileRetrieve.books.get(i).getTitle()
                                        + " → " + FileRetrieve.books.get(i).getBorrowCount()
                        );
                    }

                    System.out.println("--------------------------------------");
                    System.out.println("TOTAL BORROWS: " + total);

                    break;
                }

                case 3: {

                    System.out.println("\n📊 TRENDING AUTHORS");
                    System.out.println("======================================");

                    for (Book b : FileRetrieve.books) {
                        System.out.println(b.getAuthor() + " → " + b.getBorrowCount());
                    }

                    break;
                }

                case 4:
                    return; // 🔥 back to admin menu

                default:
                    System.out.println("Invalid Choice");
            }

        } while (true);
    }

    // ================= OTHER MENUS =================
    public static void smartReadingPaths() {

        int choice;

        do {
            System.out.println("\n🛣️ SMART READING PATHS");
            System.out.println("======================================");
            System.out.println("1. Related Book Explorer (BFS)");
            System.out.println("2. Discover Next Best Book (Dijkstra)");
            System.out.println("3. Build Reading Roadmap (Prim MST)");
            System.out.println("4. Genre Deep Exploration (DFS)");
            System.out.println("5. Back");
            System.out.println("======================================");

            System.out.print("Enter Choice : ");

            if (!sc.hasNextInt()) {
                System.out.println("❌ Invalid input. Enter number only.");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                // ================= BFS =================
                case 1 -> {
                    System.out.print("Enter Book ID: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("❌ Invalid Book ID");
                        sc.nextLine();
                        break;
                    }

                    int id = sc.nextInt();
                    sc.nextLine();

                    Book target = bst.search(id);

                    if (target == null) {
                        System.out.println("❌ Book ID not found in system");
                        break;
                    }

                    List<Book> res = SmartPathEngine.bfsRelated(FileRetrieve.books, id);

                    System.out.println("\n📚 Related Books:");

                    if (res == null || res.isEmpty()) {
                        System.out.println("❌ No related books found for: " + target.getTitle());
                        break;
                    }

                    int i = 1;
                    for (Book b : res) {
                        System.out.println(i++ + ". " + b.getTitle());
                    }
                }

                // ================= DIJKSTRA =================
                case 2 -> {
                    System.out.print("Enter Book ID: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("❌ Invalid Book ID");
                        sc.nextLine();
                        break;
                    }

                    int id = sc.nextInt();
                    sc.nextLine();

                    Book target = bst.search(id);

                    if (target == null) {
                        System.out.println("❌ Book ID not found in system");
                        break;
                    }

                    List<Book> res = SmartPathEngine.dijkstraNextBest(FileRetrieve.books, id);

                    System.out.println("\n🎯 Next Best Books:");

                    if (res == null || res.isEmpty()) {
                        System.out.println("❌ No recommendations found for: " + target.getTitle());
                        break;
                    }

                    int i = 1;
                    for (Book b : res) {
                        System.out.println(i++ + ". " + b.getTitle());
                    }
                }

                // ================= PRIM MST =================
                case 3 -> {
                    List<Book> res = SmartPathEngine.primReadingRoadmap(FileRetrieve.books);

                    System.out.println("\n🗺️ Reading Roadmap:");

                    if (res == null || res.isEmpty()) {
                        System.out.println("❌ Not enough books to build roadmap (need connections)");
                        break;
                    }

                    int i = 1;
                    for (Book b : res) {
                        System.out.println(i++ + ". " + b.getTitle());
                    }
                }

                // ================= DFS =================
                case 4 -> {
                    System.out.print("Enter Genre: ");
                    String genre = sc.nextLine().trim().toLowerCase();

                    List<Book> res = SmartPathEngine.dfsGenreExplore(FileRetrieve.books, genre);

                    System.out.println("\n📖 Genre Exploration:");

                    if (res == null || res.isEmpty()) {
                        System.out.println("❌ No books found for genre: " + genre);
                        break;
                    }

                    int i = 1;
                    for (Book b : res) {
                        System.out.println(i++ + ". " + b.getTitle());
                    }
                }

                case 5 -> {
                    System.out.println("🔙 Returning to dashboard...");
                    return;
                }

                default -> System.out.println("❌ Invalid choice. Try again.");
            }

        } while (true);
    }
   

    	public static void bookOrganizationMenu() {

            int choice;

            do {
                System.out.println("\n======================================");
                System.out.println("        BOOK ORGANIZATION");
                System.out.println("======================================");
                System.out.println("1. Sort Books By ID");
                System.out.println("2. Sort Books By Popularity");
                System.out.println("3. Back");
                System.out.println("======================================");

                System.out.print("Enter Choice : ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        Sorting.sortById(FileRetrieve.books);
                        break;

                    case 2:
                        Sorting.sortByPopularity(FileRetrieve.books);
                        break;

                    case 3:
                        return;

                    default:
                        System.out.println("Invalid Choice");
                }

            } while (true);
        }

    

    
    
}