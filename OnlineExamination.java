import java.util.Scanner;
import java.util.TimerTask;
import java.util.Timer;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String enteredPassword) {
        return password.equals(enteredPassword);
    }

    public void updateProfile(String newUsername, String newPassword) {
        this.username = newUsername;
        this.password = newPassword;
        System.out.println("Profile updated successfully!");
    }
}

class MCQs {
    private String question;
    private String[] options;
    private int correctOption;

    public MCQs(String question, String[] options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public boolean checkAnswer(int selectedOption) {
        return selectedOption == correctOption;
    }

    public void displayQuestion() {
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }
}

public class Main {
    private static Timer timer = new Timer();
    private static boolean timerExpired = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Username and Password

        User user = new User("username", "password");
        // Question Number 1
        MCQs mcqs = new MCQs(" 2 : What is the President of India ?",
                new String[] { "Ram Nath Kovind", "Pratibha Patil", "Droupadi Murmu", "Pranab Mukherjee" }, 3);
        int score = 0;

        // Taking username and password from user
        System.out.println("Welcome to the Learning Platform!");
        System.out.print("Enter your username: ");
        String enteredUsername = scanner.nextLine();
        System.out.print("Enter your password: ");
        String enteredPassword = scanner.nextLine();

        // validating Username and Password
        if (user.authenticate(enteredPassword)) {
            System.out.println("Login successful!");
            while (true) {
                System.out.println("Main Menu:");
                System.out.println("1. Update Profile and Password");
                System.out.println("2. Take a Quiz");
                System.out.println("3. Logout");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter new username: ");
                        String newUsername = scanner.nextLine();
                        System.out.print("Enter new password: ");
                        String newPassword = scanner.nextLine();
                        user.updateProfile(newUsername, newPassword);
                        break;
                    case 2:

                        // Create a timer
                        Timer timer = new Timer();

                        // Create a task to be executed after 1 minute
                        TimerTask task = new TimerTask() {
                            @Override
                            public void run() {
                                // Submit the quiz
                                System.out.println("Quiz submitted!");
                                System.exit(0);
                            }
                        };

                        // Schedule the task to be executed after 1 minute
                        timer.schedule(task, 60000); // 1 minute in milliseconds
                        mcqs.displayQuestion();
                        System.out.print("Enter your answer (1-4): ");
                        int selectedOption = scanner.nextInt();
                        if (mcqs.checkAnswer(selectedOption)) {
                            System.out.println("Correct!");
                            score++;
                        } else {
                            System.out.println("Incorrect!");
                        }
                        break;
                    case 3:
                        System.out.println("Logging out...");
                        System.out.println("Your score: " + score);
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Login failed. Incorrect password.");
        }
        scanner.close();
    }

    private static void startTimer(int seconds) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timerExpired = true;
                System.out.println("Time's up! Your quiz has been automatically submitted.");
            }
        }, seconds * 1000);
    }
}
