import java.util.Scanner;

public class NumberGuessingGame {
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

    // Play one game
    public static void playOneGame() {
        System.out.println("Guess a number from 1 to 100.");
        int low = 1;
        int high = 100;
        // Initial guess is random
        int guess = low + (int)(Math.random() * (high - low + 1));
        char response = getUserResponseToGuess(guess);

        // If the first guess is not correct, proceed with binary search
        while (response != 'c') {
            if (response == 'h') {
                low = guess + 1;
            } else if (response == 'l') {
                high = guess - 1;
            }

            // Make sure the next guess is the midpoint in the updated range
            guess = getMidpoint(low, high);
            response = getUserResponseToGuess(guess);
        }
    }

    // Get the midpoint of the range using binary search
    public static int getMidpoint(int low, int high) {
        // Return the midpoint of the range
        return (low + high) / 2;
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

    // Ask the user if the guess is correct
    public static char getUserResponseToGuess(int guess) {
        // Print a message asking if the guess is correct
        System.out.println("Is it " + guess + "? (h/l/c): ");
        // Read the user's response
        char response = scnr.next().charAt(0);
        // Keep asking until a valid response is given
        while (response != 'h' && response != 'l' && response != 'c') {
            // Print an error message if the user's response is invalid
            System.out.println("Invalid response. Please enter 'h', 'l', or 'c': ");
            // Read the user's response
            response = scnr.next().charAt(0);
        }
        // Return the user's response
        return response;
    }
}
