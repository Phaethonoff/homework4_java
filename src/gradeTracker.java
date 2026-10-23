import java.util.Scanner;

public class gradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalAssignmentPoints = 0.0;
        int assignmentCount = 0;

        double totalExamPoints = 0.0;
        int examCount = 0;

        boolean running = true;

        while (running) {
            System.out.println("===== SEMESTER GRADE TRACKER =====");
            System.out.println("1. Add assignment result");
            System.out.println("2. Add exam result");
            System.out.println("3. View current grade");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            System.out.println();

            switch (option) {
                case 1:
                    System.out.print("Enter assignment score: ");
                    double aScore = scanner.nextDouble();

                    if (aScore < 0 || aScore > 100) {
                        System.out.println("Invalid score. Enter a value from 0 to 100.\n");
                    } else {
                        totalAssignmentPoints += aScore;
                        assignmentCount++;
                        System.out.println("Assignment score added.\n");
                    }
                    break;

                case 2:
                    System.out.print("Enter exam score: ");
                    double eScore = scanner.nextDouble();

                    if (eScore < 0 || eScore > 100) {
                        System.out.println("Invalid score. Enter a value from 0 to 100.\n");
                    } else {
                        totalExamPoints += eScore;
                        examCount++;
                        System.out.println("Exam score added.\n");
                    }
                    break;

                case 3:
                    if (assignmentCount == 0 && examCount == 0) {
                        System.out.println("No results available yet.\n");
                        break;
                    }

                    System.out.println("===== CURRENT RESULTS =====");

                    double assignmentAvg = 0.0;
                    double examAvg = 0.0;
                    double overallAverage = 0.0;

                    if (assignmentCount > 0) {
                        assignmentAvg = totalAssignmentPoints / assignmentCount;
                        System.out.println("Assignments completed: " + assignmentCount);
                        System.out.printf("Assignment average: %.1f%n%n", assignmentAvg);
                    } else {
                        System.out.println("Assignments completed: 0 (No assignment data yet)\n");
                    }

                    if (examCount > 0) {
                        examAvg = totalExamPoints / examCount;
                        System.out.println("Exams completed: " + examCount);
                        System.out.printf("Exam average: %.1f%n%n", examAvg);
                    } else {
                        System.out.println("Exams completed: 0 (No exam data yet)\n");
                    }

                    // Handle weighted calculation and explain behavior if only one category exists
                    if (assignmentCount > 0 && examCount > 0) {
                        overallAverage = (assignmentAvg * 0.50) + (examAvg * 0.50);
                    } else if (assignmentCount > 0) {
                        overallAverage = assignmentAvg;
                        System.out.println("(Notice: No exams recorded yet. Overall average reflects assignment score only.)");
                    } else {
                        overallAverage = examAvg;
                        System.out.println("(Notice: No assignments recorded yet. Overall average reflects exam score only.)");
                    }

                    // Determine Letter Grade
                    char letterGrade;
                    if (overallAverage >= 90.0) {
                        letterGrade = 'A';
                    } else if (overallAverage >= 80.0) {
                        letterGrade = 'B';
                    } else if (overallAverage >= 70.0) {
                        letterGrade = 'C';
                    } else if (overallAverage >= 60.0) {
                        letterGrade = 'D';
                    } else {
                        letterGrade = 'F';
                    }

                    String status = (overallAverage >= 60.0) ? "Passing" : "Failing";

                    System.out.printf("Overall average: %.1f%n", overallAverage);
                    System.out.println("Grade: " + letterGrade);
                    System.out.println("Status: " + status + "\n");
                    break;

                case 4:
                    System.out.println("Exiting semester grade tracker.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1 and 4.\n");
                    break;
            }
        }

        scanner.close();
    }
}