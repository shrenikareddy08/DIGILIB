
import java.io.FileWriter;
import java.util.Scanner;

public class FileStore
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        FileWriter fw = new FileWriter("products.txt");

        for(int i=0;i<10;i++)
        {
            System.out.println("Enter Product Id: || ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Product Name: || ");
            String name = sc.nextLine();
            
            System.out.println("Enter Product Quantity: || ");
            int qty = sc.nextInt();

            System.out.println("Enter product Price: || ");
            double price = sc.nextDouble();
            
            fw.write(id + "," + name + "," +qty+","+ price + "\n");
        }

        fw.close();

        System.out.println("Data Stored in File");
    }
}