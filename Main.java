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
        // Ask the user for the upper and lower bounds
        System.out.println("What do you want the upper bound to be? ");
        int upperBound = scnr.nextInt();
        System.out.println("What do you want the lower bound to be? ");
        int lowerBound = scnr.nextInt();
        // Initialize the NumberGuesser with the given bounds
        NumberGuesser guesser = new NumberGuesser(lowerBound, upperBound);
        // Initialize the guess count
        int guessCount = 1;
        // Keep guessing until the computer gets it right
        while (guesser.getCurrentGuess() != 50) {
            // Print the current guess and ask the user if it's higher, lower, or correct
            System.out.println("Is it " + guesser.getCurrentGuess() + "? (h/l/c): ");
            // Read the user's response
            char response = scnr.next().charAt(0);
            // Adjust the guesser based on the user's response
            if (response == 'h') {
                guesser.higher();
            } else if (response == 'l') {
                guesser.lower();
            } else if (response == 'c') {
                // If the user says it's correct, print a message and break the loop
                System.out.println("The computer got it!");
                break;
            }
            // Increment the guess count
            guessCount++;
            // If the computer has guessed 50 times, print a message and break the loop
            if (guessCount == 50) {
                System.out.println("Computer has guessed 50 times. Either the range is too wide or the user is cheating! Game over.");
                break;
            }
        }
        // Print the number of guesses it took the computer to get the number
        System.out.println("The computer took " + guessCount + " guesses to get the number!");
    }
}
