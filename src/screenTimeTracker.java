import java.util.Scanner;

public class screenTimeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int socialMediaTime = 0;
        int gamingTime = 0;
        int studyTime = 0;
        int streamingTime = 0;

        int totalScreenTime = 0;
        int recordedSessions = 0;

        boolean running = true;

        while (running) {
            System.out.println("===== SCREEN-TIME TRACKER =====");
            System.out.println("1. Add social media time");
            System.out.println("2. Add gaming time");
            System.out.println("3. Add studying time");
            System.out.println("4. Add video or streaming time");
            System.out.println("5. View statistics");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            System.out.println();

            if (option >= 1 && option <= 4) {
                String categoryLabel = "";
                switch (option) {
                    case 1: categoryLabel = "social media"; break;
                    case 2: categoryLabel = "gaming"; break;
                    case 3: categoryLabel = "studying"; break;
                    case 4: categoryLabel = "video or streaming"; break;
                }

                System.out.print("Enter " + categoryLabel + " minutes: ");
                int minutes = scanner.nextInt();

                if (minutes <= 0) {
                    System.out.println("Invalid time. Minutes must be greater than 0.\n");
                } else {
                    switch (option) {
                        case 1: socialMediaTime += minutes; break;
                        case 2: gamingTime += minutes; break;
                        case 3: studyTime += minutes; break;
                        case 4: streamingTime += minutes; break;
                    }
                    totalScreenTime += minutes;
                    recordedSessions++;
                    System.out.println("Time added successfully!\n");
                }
            } else if (option == 5) {
                System.out.println("===== TODAY'S SCREEN TIME =====");
                System.out.println("Social media: " + socialMediaTime + " minutes");
                System.out.println("Gaming: " + gamingTime + " minutes");
                System.out.println("Studying: " + studyTime + " minutes");
                System.out.println("Streaming: " + streamingTime + " minutes\n");

                System.out.println("Total screen time: " + totalScreenTime + " minutes");
                System.out.println("Recorded sessions: " + recordedSessions + "\n");

                int entertainmentTime = socialMediaTime + gamingTime + streamingTime;


                if (studyTime > entertainmentTime) {
                    System.out.println("Study screen time is greater than entertainment screen time. Good balance!");
                } else if (entertainmentTime > studyTime) {
                    System.out.println("Entertainment screen time is greater than study time.");
                } else {
                    System.out.println("Study and entertainment screen time are equal.");
                }


                if (totalScreenTime < 120) {
                    System.out.println("Screen time category: Low screen time\n");
                } else if (totalScreenTime <= 240) {
                    System.out.println("Screen time category: Moderate screen time\n");
                } else {
                    System.out.println("Screen time category: High screen time\n");
                }
            } else if (option == 6) {
                System.out.println("Screen-time tracker closed.");
                running = false;
            } else {
                System.out.println("Invalid option. Please choose between 1 and 6.\n");
            }
        }

        scanner.close();
    }
}