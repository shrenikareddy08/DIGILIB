package bookproject;

import java.util.*;

public class DynamicProg {

    // ================= DP (POPULAR BOOKS) =================
    public static List<Book> recommendPopular(List<Book> books) {

        if (books == null || books.isEmpty()) {
            return new ArrayList<>();
        }

        List<Book> sorted = new ArrayList<>(books);

        sorted.sort((a, b) ->
                Double.compare(
                        (b.getBorrowCount() * 1.0 + b.getRating()),
                        (a.getBorrowCount() * 1.0 + a.getRating())
                )
        );

        return new ArrayList<>(
                sorted.subList(0, Math.min(3, sorted.size()))
        );
    }

    // ================= BFS (AUTHOR) =================
    public static List<Book> bfsAuthor(List<Book> books, String author) {

        List<Book> result = new ArrayList<>();

        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                result.add(b);
            }
        }

        return result;
    }

    // ================= DFS (GENRE) =================
    public static List<Book> dfsGenre(List<Book> books, String genre) {

        List<Book> result = new ArrayList<>();
        Stack<Book> st = new Stack<>();

        for (Book b : books) {
            if (b.getGenre().equalsIgnoreCase(genre)) {
                st.push(b);
            }
        }

        while (!st.isEmpty()) {
            result.add(st.pop());
        }

        return result;
    }
}