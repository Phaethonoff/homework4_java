void main() {
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
        IO.println("===== STUDY TRACKER =====");
        IO.println("1. Add study session");
        IO.println("2. View statistics");
        IO.println("3. Check weekly goal");
        IO.println("4. Exit");
        IO.print("Choose an option: ");

        int option = scanner.nextInt();
        IO.println();

        switch (option) {
            case 1:
                IO.println("Choose subject:");
                IO.println("1. Programming");
                IO.println("2. Mathematics");
                IO.println("3. English");
                IO.println("4. Other");
                IO.print("Choose an option: ");
                int subjectChoice = scanner.nextInt();

                if (subjectChoice < 1 || subjectChoice > 4) {
                    IO.println("Invalid subject choice. Returning to main menu.\n");
                    break;
                }

                IO.print("Study time in minutes: ");
                int minutes = scanner.nextInt();

                if (minutes <= 0) {
                    IO.println("Invalid study time. Time must be greater than 0.\n");
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

                IO.println("\nStudy session added!");
                IO.println("Current total study time: " + totalStudyTime + " minutes\n");
                break;

            case 2:
                IO.println("===== WEEKLY STATISTICS =====");
                IO.println("Study sessions: " + sessionCount);
                IO.println("Total study time: " + totalStudyTime + " minutes\n");
                IO.println("Programming: " + programmingTime + " minutes");
                IO.println("Mathematics: " + mathTime + " minutes");
                IO.println("English: " + englishTime + " minutes");
                IO.println("Other: " + otherTime + " minutes\n");
                break;

            case 3:
                IO.println("Weekly goal: " + weeklyGoal + " minutes");
                IO.println("You studied: " + totalStudyTime + " minutes");

                if (totalStudyTime >= weeklyGoal) {
                    IO.println("Weekly goal achieved!\n");
                } else {
                    int remaining = weeklyGoal - totalStudyTime;
                    IO.println("Remaining: " + remaining + " minutes\n");
                }
                break;

            case 4:
                IO.println("Study tracker closed. Keep up the good work!");
                running = false;
                break;

            default:
                IO.println("Invalid option. Please choose between 1 and 4.\n");
                break;
        }
    }

    scanner.close();
}