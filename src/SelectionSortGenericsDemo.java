import java.util.Scanner;
public class SelectionSortGenericsDemo {

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
        	Integer inta[]=new Integer[n];
        	System.out.println("Enter the integer elements");
        	for(int i=0;i<n;i++)
        	{
        		inta[i]=sc.nextInt();
        	}
        	SelectionSortGenerics<Integer> oi=new SelectionSortGenerics<>();
        	oi.selectionSort(inta);
        	System.out.println("sorted integers");
        	for (int i=0;i<n;i++)
        	{
        		System.out.println(inta[i]);
        	}
        	break;
        case 2:
        	Double doublea[]=new Double[n];
        	System.out.println("Enter the integer elements");
        	for(int i=0;i<n;i++)
        	{
        		doublea[i]=sc.nextDouble();
        	}
        	SelectionSortGenerics<Double> od=new SelectionSortGenerics<>();
        	od.selectionSort(doublea);
        	System.out.println("sorted integers");
        	for (int i=0;i<n;i++)
        	{
        		System.out.println(doublea[i]);
        	}
        	break;
        case 3:
        	String stra[]=new String[n];
        	System.out.println("Enter the integer elements");
        	for(int i=0;i<n;i++)
        	{
        		stra[i]=sc.next();
        	}
        	SelectionSortGenerics<String> os=new SelectionSortGenerics<>();
        	os.selectionSort(stra);
        	System.out.println("sorted integers");
        	for (int i=0;i<n;i++)
        	{
        		System.out.println(stra[i]);
        	}
        	break;
        }

	}

}
