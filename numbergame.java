import java.util.Scanner;
import java.util.Random;

public class numbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int lowerBound = 1;
            int upperBound = 100;
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            System.out.println("I have generated a number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it!");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    totalScore += (maxAttempts - attempts + 1); // Higher score for fewer attempts
                    guessedCorrectly = true;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all " + maxAttempts + " attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.println("Your current score is: " + totalScore);
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}

