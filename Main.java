import java.util.Scanner;

public class Main {

    // Declare the Scanner as a static field to be shared across methods so multiple scanners are not needed
    private static final Scanner scnr = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize the game loop
        boolean playAgain = true;

        // Start the game loop
        while (playAgain) {
            // Play one game
            playOneGame();
            // Check if the user wants to play again
            playAgain = shouldPlayAgain();
        }
    }

    // Ask the user if they want to play again
    public static boolean shouldPlayAgain() {
        // Print a message asking if the user wants to play again
        System.out.println("Do you want to play again? (y/n): ");
        // Read the user's response
        char response = scnr.next().charAt(0);
        // Keep asking until a valid response is given
        while (response != 'y' && response != 'n') {
            // Print an error message if the user's response is invalid
            System.out.println("Invalid response. Please enter 'y' or 'n': ");
            // Read the user's response
            response = scnr.next().charAt(0);
        }
        // Return true if the user wants to play again
        return response == 'y';
    }

    // Play one game
    public static void playOneGame() {
        System.out.println("What do you want the upper bound to be? ");
        int upperBound = scnr.nextInt();
        System.out.println("What do you want the lower bound to be? ");
        int lowerBound = scnr.nextInt();
        scnr.nextLine(); // Consume the newline left after nextInt()

        NumberGuesser guesser = new NumberGuesser(lowerBound, upperBound);
        boolean isCorrect = false; // Flag to keep track of whether the guess is correct
        int guessCount = 0; // Initialize guess count

        while (!isCorrect) {
            if (guessCount >= 50) {
                System.out.println("Too many guesses! Something might be wrong, or the range is too wide, or there's been a misunderstanding.");
                break; // Exit the loop if the guess count exceeds 50
            }

            System.out.println("Is it " + guesser.getCurrentGuess() + "? (h/l/c): ");
            char response = scnr.next().charAt(0);
            scnr.nextLine(); // Consume the newline

            if (response == 'h') {
                guesser.higher();
            } else if (response == 'l') {
                guesser.lower();
            } else if (response == 'c') {
                isCorrect = true; // Set the flag to true as the guess is correct
                System.out.println("The computer got it!");
            } else {
                System.out.println("Please enter 'h' for higher, 'l' for lower, or 'c' if the guess is correct.");
                continue; // Skip the rest of the loop for invalid inputs
            }
            guessCount++; // Increment guess count after a valid response or attempt
        }

        if (isCorrect) {
            // Print the number of guesses only if the user confirmed a correct guess
            System.out.println("The computer took " + guessCount + " guesses to get the number!");
        }
    }
}