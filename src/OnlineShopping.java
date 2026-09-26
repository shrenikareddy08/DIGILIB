import java.util.Scanner;
 class OnlineShopping {
     public static void main(String[] args) {
    	 
         Scanner sc = new Scanner(System.in);
         
         Product[] products = new Product[4];
         products[0] = new Product(101, "Laptop", 55000, 5);
         products[1] = new Product(102, "Mobile", 25000, 10);
         products[2] = new Product(103, "Headphones", 2000, 15);
         products[3] = new Product(104, "SmartWatch", 2500, 8);

        
         System.out.println("Available Products:");
         System.out.println("---------------------------------");
         for (int i = 0; i < products.length; i++) {
             products[i].display();
         }
        
         for (int i = 0; i < products.length - 1; i++)
          { 
              for (int j = 0; j < products.length - i - 1; j++)
              {
                  if (products[j].price > products[j + 1].price)
                  {
                      
                      Product temp = products[j];
                      products[j] = products[j + 1];
                      products[j + 1] = temp;
                  }
              }
          }
          
          System.out.println("\nAfter Sorting prices are in ascending order");
          for (int i = 0; i < products.length; i++)
          {
              products[i].display();
          }

         System.out.println("----------------------------------------------");
         System.out.println("Enter Product ID to Search:");
         int searchId = sc.nextInt();

         boolean flag = false;

       
         for (int i = 0; i < products.length; i++) {
             if (products[i].id == searchId) {
                 System.out.println("Product Found: ");
                 products[i].display();
                 
                 flag = true;
                 break;
             }
         }

         if (flag!=true) {
             System.out.println("Product Not Found");
         }

         sc.close();
     }
 }