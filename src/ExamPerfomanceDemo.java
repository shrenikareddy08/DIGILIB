import java.util.Scanner;
class ExamPerfomanceDemo
{

 public static void main(String[] args)
 {
   Scanner sc = new Scanner(System.in);
   System.out.print("Enter number of students: ");
         int n = sc.nextInt();
         ExamPerformance[] students = new ExamPerformance[n];
         for (int i = 0; i < n; i++) 
         {
             System.out.println("\nStudent " + (i + 1) + ":");
             students[i] = new ExamPerformance();
             students[i].inputStudData();
         }

         for (int i = 0; i < n; i++) 
         {
             students[i].calculateSubjectPerfomance();
             students[i].calculateOverallPerfomance();
             students[i].displayReport();
         }

 }

}