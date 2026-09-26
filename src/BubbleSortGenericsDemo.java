import java.util.Scanner;
public class BubbleSortGenericsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);

	        System.out.println("Choose Data Type for Binary Search");
	        System.out.println("1. Integer");
	        System.out.println("2. Double");
	        System.out.println("3. String");
	        System.out.print("Enter your choice: ");

	        int choice = sc.nextInt();
	        System.out.println("enter number of elements");
	        int n=sc.nextInt();
	        switch (choice) {

	            case 1:
	            	  Integer[] intArr = new Integer[n];
	            	System.out.println("enter integer elements");
	            	for(int i=0;i<n;i++) {
	            		intArr[i]=sc.nextInt();
	            		
	            	}
	            	BubbleSortGenerics<Integer> obj = new BubbleSortGenerics<>();
	            	obj.bubbleSort(intArr);
	            	System.out.println("sorted integers");
	            	for (int i=0;i<n;i++)
	            	{
	            		System.out.println(intArr[i]);
	            	}
	            	break;
	            case 2:
	            	Double[] doubleArr = new Double[n];
	                System.out.println("Enter doubles:");
	                for (int i = 0; i < n; i++)
	                    doubleArr[i] = sc.nextDouble();

	                BubbleSortGenerics<Double> od = new BubbleSortGenerics<>();
	                od.bubbleSort(doubleArr);

	                System.out.println("Sorted Doubles:");
	                for(int i=0;i<doubleArr.length;i++)
	                {
	                  System.out.println(doubleArr[i]);
	                }
	                break;

	            case 3:
	                String[] strArr = new String[n];
	                System.out.println("Enter strings:");
	                for (int i = 0; i < n; i++)
	                    strArr[i] = sc.next();

	                BubbleSortGenerics<String> os = new BubbleSortGenerics<>();
	                os.bubbleSort(strArr);

	                System.out.println("Sorted Strings:");
	                for(int i=0;i<strArr.length;i++)
	                {
	                  System.out.println(strArr[i]);
	                }
	                break;

	            default:
	                System.out.println("Invalid choice");
	        }

	        sc.close();
	  }

	}