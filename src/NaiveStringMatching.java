import java.util.Scanner;

public class NaiveStringMatching {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Text: ");
        String text = sc.nextLine();

        System.out.print("Enter Pattern: ");
        String pattern = sc.nextLine();

        int n = text.length();
        int m = pattern.length();

        int totalShifts = n - m + 1;
        int validShifts = 0;

        System.out.println("\nTotal Possible Shifts = " + totalShifts);

        System.out.println("\nShift\tPattern Comparison\tNo. of Comparisons\tMatch");

        for (int s = 0; s <= n - m; s++) {

            String sub = text.substring(s, s + m);

            int comparisons = 0;
            boolean match = true;

            for (int j = 0; j < m; j++) {
                comparisons++;

                if (sub.charAt(j) != pattern.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match)
                validShifts++;

            System.out.println(s + "\t" + pattern + " == " + sub + "\t\t"
                    + comparisons + "\t\t\t"
                    + (match ? "Yes" : "No"));
        }

        System.out.println("\nValid Shifts = " + validShifts);

        sc.close();
    }
}