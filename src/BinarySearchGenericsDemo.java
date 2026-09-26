

import java.util.Scanner;

public class BinarySearchGenericsDemo {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);

        System.out.println("Choose Data Type for Binary Search");
        System.out.println("1. Integer");
        System.out.println("2. Double");
        System.out.println("3. String");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.print("Enter number of integers: ");
                int n1 = sc.nextInt();
                Integer[] intArr = new Integer[n1];

                System.out.println("Enter integer elements:");
                for (int i = 0; i < n1; i++) {
                    intArr[i] = sc.nextInt();
                }

                System.out.print("Enter key to search: ");
                Integer intKey = sc.nextInt();

                BinarySearchGenerics<Integer> oi = new BinarySearchGenerics<>();
                int index = oi.search(intArr, intKey);
                if(index != -1)
                {
                  System.out.println("Integer Data found in index "+index);
                }
                else
                {
                  System.out.println("Integer Data not found in the array");
                }
                break;

            case 2:
                System.out.print("Enter number of doubles: ");
                int n2 = sc.nextInt();
                Double[] dblArr = new Double[n2];

                System.out.println("Enter double elements:");
                for (int i = 0; i < n2; i++) {
                    dblArr[i] = sc.nextDouble();
                }

                System.out.print("Enter key to search: ");
                Double dblKey = sc.nextDouble();

                BinarySearchGenerics<Double> od = new BinarySearchGenerics<>();
                 index = od.search(dblArr, dblKey);
                if(index != -1)
                {
                  System.out.println("Double Data found in index "+index);
                }
                else
                {
                  System.out.println("Double Data not found in the array");
                }
                break;
               
              case 3:
                System.out.print("Enter number of strings: ");
                int n3 = sc.nextInt();
                sc.nextLine(); // consume newline
                String[] strArr = new String[n3];

                System.out.println("Enter string elements:");
                for (int i = 0; i < n3; i++) 
                {
                    strArr[i] = sc.nextLine();
                }

                System.out.print("Enter key to search: ");
                String strKey = sc.nextLine();

                BinarySearchGenerics<String> os = new BinarySearchGenerics<>();
                index = os.search(strArr, strKey);

                if(index != -1)
                {
                  System.out.println("String Data found in index "+index);
                }
                else
                {
                  System.out.println("String Data not found in the array");
                }
                break;
                

            default:
                System.out.println("Invalid choice");
        }

        sc.close();// TODO Auto-generated method stub


  }

}