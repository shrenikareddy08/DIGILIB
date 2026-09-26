import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class ShoppingDemo {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("products.txt"));

        Product products[] = new Product[10];
        String line;
        int index = 0;

        while ((line = br.readLine()) != null) {

            String parts[] = line.split(",");

            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            int qty = Integer.parseInt(parts[2]);
            double price = Double.parseDouble(parts[3]);

            products[index++] = new Product(id, name, price, qty);
        }

        br.close();

        Scanner sc = new Scanner(System.in);
        Sort s = new Sort();

        System.out.println("1. Sort by Price Ascending");
        System.out.println("2. Sort by Price Descending");
        System.out.println("3. Sort by Name");

        int choice = sc.nextInt();

        if (choice == 1) {
            s.sortByAscending(products, 0, products.length - 1);
        } 
        else if (choice == 2) {
            s.sortByDescending(products, 0, products.length - 1);
        } 
        else if (choice == 3) {
            s.sortByName(products);
        }

        System.out.println("\nSorted Products:\n");

        for (Product p : products) {
            p.display();
        }
    }
}


