import java.util.Scanner;

class ShoppingCartMenu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SLL p1 = new SLL();

        System.out.println("Let us start shopping");

        while (true) {

            System.out.println("\nWELCOME TO OUR SHOP");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Count Products");
            System.out.println("4. Show Cart");
            System.out.println("5. Total Bill");
            System.out.println("6. EXIT");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                	  p1.createShopCart();
                	    break;

                case 2:
                    System.out.println("Enter product name to remove:");
                    String removeName = sc.nextLine();
                    p1.removeProducts(removeName);
                    break;

                case 3:
                    p1.countProducts();
                    break;

                case 4:
                    p1.display();
                    break;

                case 5:
                    p1.totalCart();
                    break;

                case 6:
                    System.out.println("Thank you for shopping!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}