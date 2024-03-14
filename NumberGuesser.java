public class NumberGuesser {
    
    // Declare private fields for the lower and higher bounds of the guesser
    private int lowerBound;
    private int higherBound;
    // Declare private fields for the starting lower and higher bounds of the guesser
    private int startingLowerBound;
    private int startingHigherBound;

    // Constructor for the NumberGuesser class that initializes the bounds
    public NumberGuesser(int lowerBound, int higherBound) {
        this.lowerBound = lowerBound;
        this.higherBound = higherBound;
        this.startingLowerBound = lowerBound;
        this.startingHigherBound = higherBound;
    }
    
    // Method to adjust the lower bound to the current guess + 1
    public void higher() {
        this.lowerBound = getCurrentGuess() + 1;
    }

    // Method to adjust the higher bound to the current guess - 1
    public void lower() {
        this.higherBound = getCurrentGuess() - 1;
    }

    // Method to calculate and return the current guess as the average of the lower and higher bounds
    public int getCurrentGuess() {
        return (this.lowerBound + this.higherBound) / 2;
    }

    // Method to reset the bounds to their original values
    public void reset() {
        this.lowerBound = this.startingLowerBound;
        this.higherBound = this.startingHigherBound;
    }

}
