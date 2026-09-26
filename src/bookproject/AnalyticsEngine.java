package bookproject;

import java.util.*;

public class AnalyticsEngine {

    // ================= MOST BORROWED =================
    public static List<Book> mostBorrowed(List<Book> books) {

        List<Book> sorted = new ArrayList<>(books);

        sorted.sort((a, b) ->
                Integer.compare(b.getBorrowCount(), a.getBorrowCount())
        );

        return sorted;
    }

    // ================= TRENDING AUTHORS =================
    public static Map<String, Integer> trendingAuthors(List<Book> books) {

        Map<String, Integer> map = new HashMap<>();

        for (Book b : books) {
            map.put(b.getAuthor(),
                    map.getOrDefault(b.getAuthor(), 0) + b.getBorrowCount());
        }

        return map;
    }

    // ================= CATEGORY POPULARITY =================
    public static Map<String, Integer> categoryPopularity(List<Book> books) {

        Map<String, Integer> map = new HashMap<>();

        for (Book b : books) {
            map.put(b.getGenre(),
                    map.getOrDefault(b.getGenre(), 0) + b.getBorrowCount());
        }

        return map;
    }

    // ================= BORROW TREND =================
    public static List<Integer> borrowTrend(List<Book> books) {

        List<Integer> trend = new ArrayList<>();

        for (Book b : books) {
            trend.add(b.getBorrowCount());
        }

        return trend;
    }
}