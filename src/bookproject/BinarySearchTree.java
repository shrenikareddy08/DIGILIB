package bookproject;

public class BinarySearchTree {

    class Node {
        Book book;
        Node left, right;

        Node(Book book) {
            this.book = book;
        }
    }

    Node root;

    // ================= INSERT =================
    public void insert(Book book) {
        root = insertRec(root, book);
    }

    private Node insertRec(Node root, Book book) {

        if (root == null)
            return new Node(book);

        if (book.getBookId() < root.book.getBookId())
            root.left = insertRec(root.left, book);

        else if (book.getBookId() > root.book.getBookId())
            root.right = insertRec(root.right, book);

        return root;
    }

    // ================= DISPLAY ALL =================
    public void displayBooks() {
        inorder(root);
    }

    private void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.book);
            System.out.println("-------------------");
            inorder(root.right);
        }
    }

    // ================= SEARCH =================
    public Book search(int bookId) {
        return searchRec(root, bookId);
    }

    private Book searchRec(Node root, int bookId) {

        if (root == null)
            return null;

        if (root.book.getBookId() == bookId)
            return root.book;

        if (bookId < root.book.getBookId())
            return searchRec(root.left, bookId);

        return searchRec(root.right, bookId);
    }

    // ================= DELETE =================
    public void delete(int bookId) {
        root = deleteRec(root, bookId);
    }

    private Node deleteRec(Node root, int bookId) {

        if (root == null)
            return null;

        if (bookId < root.book.getBookId())
            root.left = deleteRec(root.left, bookId);

        else if (bookId > root.book.getBookId())
            root.right = deleteRec(root.right, bookId);

        else {

            if (root.left == null)
                return root.right;

            if (root.right == null)
                return root.left;

            root.book = minValue(root.right);
            root.right = deleteRec(root.right, root.book.getBookId());
        }

        return root;
    }

    private Book minValue(Node root) {

        Book min = root.book;

        while (root.left != null) {
            root = root.left;
            min = root.book;
        }

        return min;
    }
}