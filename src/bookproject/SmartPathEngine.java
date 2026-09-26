package bookproject;

import java.util.*;

public class SmartPathEngine {

    // ================= BFS (RELATED BOOKS) =================
    public static List<Book> bfsRelated(List<Book> books, int id) {

        List<Book> result = new ArrayList<>();
        Queue<Book> q = new LinkedList<>();

        Book start = null;

        for (Book b : books) {
            if (b.getBookId() == id) {
                start = b;
                break;
            }
        }

        if (start == null) return result;

        q.add(start);
        Set<Integer> visited = new HashSet<>();
        visited.add(start.getBookId());

        while (!q.isEmpty()) {

            Book curr = q.poll();

            for (Book b : books) {

                if (!visited.contains(b.getBookId())
                        && b.getGenre().equalsIgnoreCase(curr.getGenre())) {

                    result.add(b);
                    q.add(b);
                    visited.add(b.getBookId());
                }
            }
        }

        return result;
    }

    // ================= DIJKSTRA (NEXT BEST BOOK) =================
    public static List<Book> dijkstraNextBest(List<Book> books, int id) {

        List<Book> result = new ArrayList<>();

        Book start = null;
        for (Book b : books) {
            if (b.getBookId() == id) {
                start = b;
                break;
            }
        }

        if (start == null) return result;

        PriorityQueue<Book> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(
                        (b.getRating() + b.getBorrowCount()),
                        (a.getRating() + a.getBorrowCount())
                )
        );

        for (Book b : books) {
            if (b.getBookId() != id) {
                pq.add(b);
            }
        }

        int count = 0;
        while (!pq.isEmpty() && count < 5) {
            result.add(pq.poll());
            count++;
        }

        return result;
    }

    // ================= PRIM (READING ROADMAP) =================
    public static List<Book> primReadingRoadmap(List<Book> books) {

        List<Book> result = new ArrayList<>();
        if (books.isEmpty()) return result;

        Set<Book> visited = new HashSet<>();
        visited.add(books.get(0));
        result.add(books.get(0));

        while (visited.size() < books.size()) {

            Book best = null;

            for (Book b : books) {

                if (!visited.contains(b)) {

                    if (best == null ||
                            b.getRating() > best.getRating()) {
                        best = b;
                    }
                }
            }

            if (best != null) {
                visited.add(best);
                result.add(best);
            } else break;
        }

        return result;
    }

    // ================= DFS (GENRE EXPLORATION) =================
    public static List<Book> dfsGenreExplore(List<Book> books, String genre) {

        List<Book> result = new ArrayList<>();
        Stack<Book> st = new Stack<>();

        for (Book b : books) {
            if (b.getGenre().equalsIgnoreCase(genre)) {
                st.push(b);
            }
        }

        Set<Integer> visited = new HashSet<>();

        while (!st.isEmpty()) {

            Book b = st.pop();

            if (!visited.contains(b.getBookId())) {
                result.add(b);
                visited.add(b.getBookId());
            }
        }

        return result;
    }
}