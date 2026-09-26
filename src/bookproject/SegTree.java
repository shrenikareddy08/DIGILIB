package bookproject;

public class SegTree {

    int[] tree;
    int n;

    public SegTree(int[] arr) {

        n = arr.length;

        if (n == 0) return;

        tree = new int[4 * n];
        build(0, 0, n - 1, arr);
    }

    private void build(int node, int start, int end, int[] arr) {

        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        build(2 * node + 1, start, mid, arr);
        build(2 * node + 2, mid + 1, end, arr);

        tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
    }

    // update borrow count of a book
    public void update(int index, int value) {
        if (n == 0) return;
        updateRec(0, 0, n - 1, index, value);
    }

    private void updateRec(int node, int start, int end, int index, int value) {

        if (start == end) {
            tree[node] = value;
            return;
        }

        int mid = (start + end) / 2;

        if (index <= mid)
            updateRec(2 * node + 1, start, mid, index, value);
        else
            updateRec(2 * node + 2, mid + 1, end, index, value);

        tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
    }

    // MOST BORROWED BOOK COUNT
    public int getMostPopularBookBorrowCount() {
        return n == 0 ? 0 : tree[0];
    }
}