import java.util.Scanner;
public class TimeComplexity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter n value");
		int n = sc.nextInt();
		long start = System.nanoTime();
		int i, s=0;
		for (i=1;i<=n;i++)
		{
			s=s+1;
	
		}
		System.out.println("sum is"+s);
		long end = System.nanoTime();
		long duration = end-start;
		System.out.println("duration is"+duration);
		

	}

}

