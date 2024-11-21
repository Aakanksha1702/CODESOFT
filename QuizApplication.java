import java.util.*;

public class QuizApplication {
    static Scanner scanner = new Scanner(System.in);
    static int score = 0;

    public static void main(String[] args) {
        // Quiz data: questions, options, and correct answers
        String[][] questions = {
                {"What is the capital of France?", "1. Berlin", "2. Madrid", "3. Paris", "4. Rome", "3"},
                {"Who wrote 'Hamlet'?", "1. Charles Dickens", "2. William Shakespeare", "3. Jane Austen", "4. Mark Twain", "2"},
                {"What is the largest planet in our solar system?", "1. Earth", "2. Jupiter", "3. Saturn", "4. Mars", "2"},
                {"Which element has the chemical symbol 'O'?", "1. Gold", "2. Oxygen", "3. Osmium", "4. Hydrogen", "2"},
                {"What is the square root of 64?", "1. 6", "2. 7", "3. 8", "4. 9", "3"}
        };

        List<String> summary = new ArrayList<>();
        System.out.println("Welcome to the Quiz!");
        System.out.println("You have 10 seconds to answer each question.");
        System.out.println("Good luck!\n");

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i][0]);
            for (int j = 1; j <= 4; j++) {
                System.out.println(questions[i][j]);
            }

            int userAnswer = getUserAnswerWithTimer();
            if (userAnswer == -1) {
                System.out.println("⏰ Time's up! Moving to the next question.\n");
                summary.add("Question " + (i + 1) + ": Incorrect (Timed Out)");
            } else if (String.valueOf(userAnswer).equals(questions[i][5])) {
                System.out.println("✅ Correct!\n");
                score++;
                summary.add("Question " + (i + 1) + ": Correct");
            } else {
                System.out.println("❌ Incorrect! The correct answer was option " + questions[i][5] + ".\n");
                summary.add("Question " + (i + 1) + ": Incorrect");
            }
        }

        // Display the final results
        System.out.println("\n--- Quiz Results ---");
        System.out.println("Score: " + score + " / " + questions.length);
        System.out.println("Summary:");
        for (String s : summary) {
            System.out.println(s);
        }
        System.out.println("Thank you for playing!");
    }

    // Method to get user input with a timer
    public static int getUserAnswerWithTimer() {
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("\n⏳ Time's up!");
                System.exit(0);
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 10000); // 10 seconds timer

        int answer;
        try {
            System.out.print("Enter your answer (1-4): ");
            answer = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next(); // Clear invalid input
            answer = -1; // Consider invalid input as timeout
        }
        timer.cancel();
        return answer;
    }
}
