import java.util.Scanner;

public class TimerAndStopwatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Timer");
            System.out.println("2. Stopwatch");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter timer duration in seconds: ");
                    int timerDuration = scanner.nextInt();
                    startTimer(timerDuration);
                    break;
                case 2:
                    startStopwatch();
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 3);
        scanner.close();
    }

    private static void startTimer(int duration) {
        System.out.println("Timer started for " + duration + " seconds.");
        try {
            Thread.sleep(duration * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Time's up!");
    }

    private static void startStopwatch() {
        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Stopwatch started. Press Enter to stop.");
        scanner.nextLine();
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;

        long seconds = elapsedTime / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long milliseconds = elapsedTime % 1000;

        System.out.println("Elapsed Time: " + hours + "h " + minutes % 60 + "m " + seconds % 60 + "s " + milliseconds + "ms");
        scanner.close();
    }
}
