import java.util.Scanner;

public class studyTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int weeklyGoal = 600;
        int totalStudyTime = 0;
        int sessionCount = 0;

        int programmingTime = 0;
        int mathTime = 0;
        int englishTime = 0;
        int otherTime = 0;

        boolean running = true;

        while (running) {
            System.out.println("===== STUDY TRACKER =====");
            System.out.println("1. Add study session");
            System.out.println("2. View statistics");
            System.out.println("3. Check weekly goal");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            System.out.println();

            switch (option) {
                case 1:
                    System.out.println("Choose subject:");
                    System.out.println("1. Programming");
                    System.out.println("2. Mathematics");
                    System.out.println("3. English");
                    System.out.println("4. Other");
                    System.out.print("Choose an option: ");
                    int subjectChoice = scanner.nextInt();

                    if (subjectChoice < 1 || subjectChoice > 4) {
                        System.out.println("Invalid subject choice. Returning to main menu.\n");
                        break;
                    }

                    System.out.print("Study time in minutes: ");
                    int minutes = scanner.nextInt();

                    if (minutes <= 0) {
                        System.out.println("Invalid study time. Time must be greater than 0.\n");
                        break;
                    }

                    switch (subjectChoice) {
                        case 1:
                            programmingTime += minutes;
                            break;
                        case 2:
                            mathTime += minutes;
                            break;
                        case 3:
                            englishTime += minutes;
                            break;
                        case 4:
                            otherTime += minutes;
                            break;
                    }

                    totalStudyTime += minutes;
                    sessionCount++;

                    System.out.println("\nStudy session added!");
                    System.out.println("Current total study time: " + totalStudyTime + " minutes\n");
                    break;

                case 2:
                    System.out.println("===== WEEKLY STATISTICS =====");
                    System.out.println("Study sessions: " + sessionCount);
                    System.out.println("Total study time: " + totalStudyTime + " minutes\n");
                    System.out.println("Programming: " + programmingTime + " minutes");
                    System.out.println("Mathematics: " + mathTime + " minutes");
                    System.out.println("English: " + englishTime + " minutes");
                    System.out.println("Other: " + otherTime + " minutes\n");
                    break;

                case 3:
                    System.out.println("Weekly goal: " + weeklyGoal + " minutes");
                    System.out.println("You studied: " + totalStudyTime + " minutes");

                    if (totalStudyTime >= weeklyGoal) {
                        System.out.println("Weekly goal achieved!\n");
                    } else {
                        int remaining = weeklyGoal - totalStudyTime;
                        System.out.println("Remaining: " + remaining + " minutes\n");
                    }
                    break;

                case 4:
                    System.out.println("Study tracker closed. Keep up the good work!");
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