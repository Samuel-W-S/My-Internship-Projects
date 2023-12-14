import java.util.Scanner;

public class AdventureGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Adventure of the Lost Artifact!");
        System.out.println("You are a young boy named Alex, and you have heard legends of a powerful artifact hidden in the mystical Forest of Shadows.");

        while (true) {
            System.out.println("\nChoose your path, Alex:");
            System.out.println("1. Take the winding trail through the Enchanted Meadow");
            System.out.println("2. Brave the treacherous Caves of Echoes");
            System.out.println("3. Seek the guidance of the Wise Old Sage");

            int choice = getUserChoice(scanner, 3);

            switch (choice) {
                case 1:
                    System.out.println("You chose to take the winding trail through the Enchanted Meadow.");
                    System.out.println("As you stroll through the meadow, you encounter magical creatures who offer you a magical map.");
                    System.out.println("The map guides you safely through the forest, avoiding dangers.");
                    System.out.println("You find the entrance to the hidden cavern containing the artifact.");
                    break;
                case 2:
                    System.out.println("You decide to brave the treacherous Caves of Echoes.");
                    System.out.println("Inside the dark caves, you face challenges and mysterious echoes that disorient you.");
                    System.out.println("With careful navigation, you discover a secret passage leading to the artifact.");
                    break;
                case 3:
                    System.out.println("You choose to seek the guidance of the Wise Old Sage.");
                    System.out.println("The sage imparts ancient wisdom and warns you of the Forest Guardian.");
                    System.out.println("With this knowledge, you successfully outwit the guardian and reach the artifact.");
                    break;
            }

            System.out.println("Congratulations, Alex! You have found the legendary artifact. Game over.");
            break;
        }

        scanner.close();
    }

    private static int getUserChoice(Scanner scanner, int maxChoice) {
        int choice = 0;
        boolean validInput = false;

        do {
            System.out.print("Enter your choice (1-" + maxChoice + "): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= maxChoice) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and " + maxChoice + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // consume the invalid input
            }
        } while (!validInput);

        return choice;
    }
}
