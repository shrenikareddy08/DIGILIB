package fileHandling;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class FileReaderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
         System.out.print("Enter text to store in file: ");
         String data = sc.nextLine();  // Taking user input
           try {
               // Create FileWriter object to write into a file
               FileWriter fw = new FileWriter("d:\\output.txt",true);
               fw.write(data);   // Writing data to file
               fw.close();       // Closing file

               System.out.println("Data successfully written to output.txt");
           } 
           catch (IOException e) {
               System.out.println("An error occurred.");
               e.printStackTrace();
           }

	}

}
