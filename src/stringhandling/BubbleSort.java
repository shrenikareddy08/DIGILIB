package stringhandling;
import java.util.Scanner;
public class BubbleSort {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of strings:");
        int n = sc.nextInt();
        String a[] = new String[n];
        int i , j;
        System.out.println("Enter the strings:");
        for ( i = 0; i < a.length ; i++)
        {
            a[i] = sc.next();
        }
        for (i = 0; i <  a.length -1; i++)
        {
        	for (j = 0; j < a.length - i - 1; j++)
        	{
        		if (a[j].compareTo(a[j+1]) > 0)
        		{
        			String temp = a[j];
        			a[j] = a[j+1];
        			a[j+1] = temp;
        			
        		}
        	}
        }
        System.out.println("Strings in  alphabetical order");
        for (i=0; i<a.length ; i++)
        {
        	System.out.println(a[i] + " ");
        }
        
        
	}
}
