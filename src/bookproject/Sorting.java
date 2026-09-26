package bookproject;

import java.util.ArrayList;

public class Sorting {

    // ================= SORT BY ID (QUICK SORT) =================
    public static void sortById(ArrayList<Book> books) {

        quickSortById(books, 0, books.size() - 1);

        System.out.println("\n📚 Books Sorted by ID:");

        for (Book b : books) {
            System.out.println("Book ID : " + b.getBookId());
        }
    }

    private static void quickSortById(ArrayList<Book> books, int low, int high) {

        if (low < high) {

            int pi = partition(books, low, high);

            quickSortById(books, low, pi - 1);
            quickSortById(books, pi + 1, high);
        }
    }

    private static int partition(ArrayList<Book> books, int low, int high) {

        int pivot = books.get(high).getBookId();

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (books.get(j).getBookId() < pivot) {

                i++;

                Book temp = books.get(i);
                books.set(i, books.get(j));
                books.set(j, temp);
            }
        }

        Book temp = books.get(i + 1);
        books.set(i + 1, books.get(high));
        books.set(high, temp);

        return i + 1;
    }

    // ================= SORT BY POPULARITY (MERGE SORT) =================
    public static void sortByPopularity(ArrayList<Book> books) {

        mergeSortPopularity(books);

        System.out.println("\n🔥 Books Sorted by Popularity:");

        int rank = 1;

        for (Book b : books) {

            System.out.println(rank + ". Book ID : "
                    + b.getBookId()
                    + " | Borrow Count : "
                    + b.getBorrowCount());

            rank++;
        }
    }

    private static void mergeSortPopularity(ArrayList<Book> books) {

        if (books.size() <= 1)
            return;

        int mid = books.size() / 2;

        ArrayList<Book> left =
                new ArrayList<>(books.subList(0, mid));

        ArrayList<Book> right =
                new ArrayList<>(books.subList(mid, books.size()));

        mergeSortPopularity(left);
        mergeSortPopularity(right);

        merge(books, left, right);
    }

    private static void merge(ArrayList<Book> books,
                              ArrayList<Book> left,
                              ArrayList<Book> right) {

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.size() && j < right.size()) {

            if (left.get(i).getBorrowCount()
                    >= right.get(j).getBorrowCount()) {

                books.set(k++, left.get(i++));
            } else {

                books.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            books.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            books.set(k++, right.get(j++));
        }
    }
}