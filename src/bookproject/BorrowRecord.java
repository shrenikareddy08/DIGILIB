package bookproject;

public class BorrowRecord {

    private int borrowId;
    private String userId;
    private int bookId;

    private String borrowDate;
    private String dueDate;
    private String returnDate;
    private String status;

    public BorrowRecord(int borrowId, String userId, int bookId,
                        String borrowDate, String dueDate,
                        String returnDate, String status) {

        this.borrowId = borrowId;
        this.userId = userId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
    }
    
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    // getters
    public int getBorrowId() { return borrowId; }
    public String getUserId() { return userId; }
    public int getBookId() { return bookId; }
    public String getBorrowDate() { return borrowDate; }
    public String getDueDate() { return dueDate; }
    public String getReturnDate() { return returnDate; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return "Borrow ID : " + borrowId +
                "\nUser ID : " + userId +
                "\nBook ID : " + bookId +
                "\nBorrow Date : " + borrowDate +
                "\nDue Date : " + dueDate +
                "\nReturn Date : " + returnDate +
                "\nStatus : " + status;
    }
}