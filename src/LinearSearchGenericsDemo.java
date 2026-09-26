import java.util.Scanner;
public class LinearSearchGenericsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("choose data type");
		System.out.println("1.INTEGER");
		System.out.println("2.DOUBLE");
		System.out.println("3.STRING");
		System.out.println("enter your choice");
		int ch=sc.nextInt();
		switch(ch) {
		case 1: 
			System.out.println("enter number of integers");
			int n=sc.nextInt();
			Integer[] intArr=new Integer[n];
			System.out.println("enter integer elements");
			for(int i=0;i<n;i++)
			{
				intArr[i]=sc.nextInt();
				
			}
			System.out.println("Enter key to search");
			Integer intkey=sc.nextInt();
			LinearSearchGenerics<Integer> oi= new LinearSearchGenerics<>();
			int index = oi.search(intArr,intkey);
			if(index!=-1)
			{
				System.out.println("data found at"+index);
				
			}
			else
			{
				System.out.println("data not found");
			}
			break;
		case 2: 
			System.out.println("enter number of doubles");
			int n2=sc.nextInt();
			Double[] doubleArr=new Double[n2];
			System.out.println("enter double elements");
			for(int i=0;i<n2;i++)
			{
				doubleArr[i]=sc.nextDouble();
				
			}
			System.out.println("Enter key to search");
			Double doubleKey=sc.nextDouble();
			LinearSearchGenerics<Double> od= new LinearSearchGenerics<>();
			 index = od.search(doubleArr, doubleKey);
			if(index!=-1)
			{
				System.out.println("data found at"+index);
				
			}
			else
			{
				System.out.println("data not found");
			}
			break;
		case 3:
            System.out.print("Enter number of strings: ");
            int n3 = sc.nextInt();
            sc.nextLine(); 
            String[] strArr = new String[n3];

            System.out.println("Enter string elements:");
            for (int i = 0; i < n3; i++) 
            {
                strArr[i] = sc.nextLine();
            }

            System.out.print("Enter key to search: ");
            String strKey = sc.nextLine();

            LinearSearchGenerics<String> os = new LinearSearchGenerics<>();
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
	}
}