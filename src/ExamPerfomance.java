import java.util.Scanner;
 class ExamPerformance
{
 private String name;
 private int rollNo;
 private String subjects[] = {"Java", "DSD" , "BEEC"};
 private int[] theoryMarks = new int [3];
 private int[] practicalMarks = new int [3];
 private double[] subjectAvg = new double[3];
 private String[] tags = new String[3];
 private String[] skillRating = new String[3];
 private int totalTheory;
 private int totalPractical;
 private double overallAvg;
 private String overallGrade;
 private String summary;
 private String improvementTip;
 public void inputStudData()
 {
  Scanner sc = new Scanner(System.in);
  System.out.println("Enter Student Name: ");
  this.name = sc.next();
  sc.nextLine();
  System.out.println("Enter Student Roll Number: ");
  this.rollNo = sc.nextInt();
  for (int i = 0; i < 3; i++) 
  {
      System.out.print(subjects[i] + " : Theory: ");
      theoryMarks[i] = sc.nextInt();
      System.out.print(subjects[i] + " : Practical: ");
      practicalMarks[i] = sc.nextInt();
  }

 }
 public void calculateSubjectPerfomance()
 {
  for (int i = 0; i < 3; i++)
  {
   subjectAvg[i] = (theoryMarks[i] + practicalMarks[i]) / 2.0;
   if (subjectAvg[i] >= 91) 
   {
                tags[i] = "OUTSTANDING";
                skillRating[i] = "(5)";
            }
   else if (subjectAvg[i] >= 81) 
            {
                tags[i] = "VERY GOOD";
                skillRating[i] = "(4)";
            }
            else if (subjectAvg[i] >= 61) 
            {
                tags[i] = "GOOD";
                skillRating[i] = "(3)";
            } 
            else if (subjectAvg[i] >= 41) 
            {
                tags[i] = "AVERAGE";
                skillRating[i] = "(2)";
            } 
            else 
            {
                tags[i] = "POOR";
                skillRating[i] = "(1)";
            }
        }
    }
 public void calculateOverallPerfomance()
 {
  totalTheory = 0;
        totalPractical = 0;
        for (int i = 0; i < 3; i++) 
        {
            totalTheory = totalTheory + theoryMarks[i];
            totalPractical = totalPractical + practicalMarks[i];
        }
        overallAvg = (totalTheory + totalPractical) / 3.0;
        if (overallAvg >= 91) 
         {
         overallGrade = "A+";
         }
        else if (overallAvg >= 81)
         { 
         overallGrade = "A";
         }
        else if (overallAvg >= 71)
         {
         overallGrade = "B";
         }
        else if (overallAvg >= 61)
         {
         overallGrade = "C";
         }
        else 
         {
         overallGrade = "D";
         }
        switch (overallGrade)
        {
        case "A+":
            summary = "Outstanding performance";
            break;

        case "A":
            summary = "Excellent performance";
            break;

        case "B":
            summary = "Good performance";
            break;

        case "C":
            summary = "Average performance";
            break;
            default:
            summary = "Need improvement";
            break;
    }
        int weakestIndex = 0;
     for (int i = 1; i < 3; i++)
     {
         if (subjectAvg[i] < subjectAvg[weakestIndex]) 
         {
             weakestIndex = i;
         }
     }
     improvementTip = "Focus more on " + subjects[weakestIndex];
 }
 public void displayReport()
 {
   System.out.println("EXAM REPORT");
         System.out.println("Name       : " +this.name);
        System.out.println("Register No: " +this.rollNo);
         System.out.println("Subject-wise Performance:");
         for (int i = 0; i < 3; i++)
         {
          System.out.println("  Theory: " + theoryMarks[i]);
          System.out.println("  Practical: " + practicalMarks[i]);
          System.out.println("  Tag: " + tags[i]);
          System.out.println("  Skill: " + skillRating[i]);
          System.out.println(); 
         }
         System.out.println("Total Theory Marks : " + totalTheory);
         System.out.println("Total Practical Marks: " + totalPractical);
         System.out.printf("Overall Average  : %.2f\n", overallAvg);
         System.out.println("Overall Grade  : " + overallGrade);
         System.out.println("Summary  : " + summary);
         System.out.println("Improvement Tip : " + improvementTip);
 }
}