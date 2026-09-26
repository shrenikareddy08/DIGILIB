package fileHandling;


import java.io.FileReader;
import java.io.IOException;

public class FileDemo
{

  public static void main(String[] args) 
  {
    // TODO Auto-generated method stub
     // Create File object for the text file
       try {
                // FileReader with filename directly (NO File class)
                FileReader fr = new FileReader("d:\\output.txt");

                int ch;
                System.out.println("Reading data from output.txt:");
                System.out.println("--------------------------------");

                // Read one character at a time
                while ((ch = fr.read()) != -1) {
                    System.out.println((char) ch);
                }

                fr.close();
            } 
            catch (IOException e) {
                System.out.println("Error while reading the file.");
                e.printStackTrace();
            }
        
       
        }
}