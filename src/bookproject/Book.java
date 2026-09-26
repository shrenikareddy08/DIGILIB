package bookproject;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private String genre;

    private int availableCopies;
    private int totalCopies;
    private int borrowCount;
    private double rating;

    public Book(int bookId, String title, String author, String genre,
                int availableCopies, int totalCopies,
                int borrowCount, double rating) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availableCopies = availableCopies;
        this.totalCopies = totalCopies;
        this.borrowCount = borrowCount;
        this.rating = rating;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public double getRating() {
        return rating;
    }
    
    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public void setBorrowCount(int borrowCount) {
        this.borrowCount = borrowCount;
    }

    @Override
    public String toString() {
        return "Book ID : " + bookId +
                "\nTitle : " + title +
                "\nAuthor : " + author +
                "\nGenre : " + genre +
                "\nAvailable Copies : " + availableCopies +
                "\nTotal Copies : " + totalCopies +
                "\nBorrow Count : " + borrowCount +
                "\nRating : " + rating;
    }
}