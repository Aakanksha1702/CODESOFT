
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Input: Marks for each subject
        int[] marks = new int[numSubjects];
        int totalMarks = 0;
        System.out.println("Enter marks obtained in each subject (out of 100):");
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            while (marks[i] < 0 || marks[i] > 100) { // Validation
                System.out.println("Invalid marks! Please enter a value between 0 and 100.");
                System.out.print("Subject " + (i + 1) + ": ");
                marks[i] = scanner.nextInt();
            }
            totalMarks += marks[i];
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Calculate grade
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B+";
        } else if (averagePercentage >= 60) {
            grade = "B";
        } else if (averagePercentage >= 50) {
            grade = "C";
        } else if (averagePercentage >= 40) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display results
        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks + " / " + (numSubjects * 100));
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);

        // Add feedback
        if (grade.equals("F")) {
            System.out.println("Feedback: You need to work harder. Better luck next time!");
        } else if (grade.equals("D") || grade.equals("C")) {
            System.out.println("Feedback: Keep improving, you're on the right track!");
        } else if (grade.equals("B") || grade.equals("B+")) {
            System.out.println("Feedback: Good job! Aim for an even higher grade next time.");
        } else if (grade.equals("A") || grade.equals("A+")) {
            System.out.println("Feedback: Excellent performance! Keep up the great work!");
        }

        scanner.close();
    }
}
