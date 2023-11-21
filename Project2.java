import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int MinValue = 1;
        int MaxValue = 100;
        int RandomNumber = random.nextInt(MaxValue - MinValue + 1) + MinValue;
        int Attempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a random number between " + MinValue + " and " + MaxValue + ". Try to guess the number .");

        for(; ;){
            System.out.print("Enter your guess : ");
            int UserGuess = scanner.nextInt();
            Attempts++;

            if (UserGuess < MinValue || UserGuess > MaxValue) {
                System.out.println("Please guess within the given valid range.");
            } else if (UserGuess < RandomNumber) {
                System.out.println("The number is too low! Try again.");
            } else if (UserGuess > RandomNumber) {
                System.out.println("The number is too high! Try again.");
            } else {
                System.out.println("Congratulations ! You guessed the correct number in " + Attempts + " attempts.");
                break;
            }
        }
    }
}