package bookproject;

public class FenTree {

    int[] bit;
    int n;

    public FenTree(int n) {
        this.n = n;
        bit = new int[n + 1];
    }

    // add value at index
    public void update(int index, int value) {

        for (int i = index + 1; i <= n; i += i & -i) {
            bit[i] += value;
        }
    }

    // prefix sum
    public int query(int index) {

        int sum = 0;

        for (int i = index + 1; i > 0; i -= i & -i) {
            sum += bit[i];
        }

        return sum;
    }

    // range sum
    public int rangeQuery(int l, int r) {
        return query(r) - query(l - 1);
    }
}