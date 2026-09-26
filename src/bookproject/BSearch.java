package bookproject;

import java.util.ArrayList;
import java.util.Comparator;

public class BSearch {

    // 🔥 Simulating B+ Tree leaf node behavior using sorted list
    public static Book searchById(ArrayList<Book> books, int id) {

        // Step 1: Sort (like B+ tree leaf order)
        books.sort(Comparator.comparingInt(Book::getBookId));

        int low = 0;
        int high = books.size() - 1;

        // Step 2: Binary Search (B+ tree search logic)
        while (low <= high) {

            int mid = (low + high) / 2;
            Book b = books.get(mid);

            if (b.getBookId() == id) {
                return b;
            }

            if (id < b.getBookId()) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return null;
    }
}