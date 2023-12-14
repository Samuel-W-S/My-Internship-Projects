import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Simple Story Game!");
        System.out.print("Enter your character's name: ");
        String playerName = scanner.nextLine();

        System.out.println("\nHello, " + playerName + "! Your adventure begins...");

        // Start of the story
        System.out.println("\nYou find yourself in a small village. The village elder approaches you.");
        System.out.println("Elder: " + playerName + ", we need your help. A dragon has been terrorizing our lands.");

        // Player makes a choice
        System.out.print("Will you accept the quest to defeat the dragon? (yes/no): ");
        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("yes")) {
            System.out.println("\nYou bravely accept the quest and set off to find the dragon.");
            System.out.println("After a long journey, you reach the dragon's lair.");

            // Player faces the dragon
            System.out.println("\nThe dragon is sleeping. You see a sword nearby.");
            System.out.print("Will you try to sneak past the dragon or attempt to slay it with the sword? (sneak/slay): ");
            String action = scanner.nextLine().toLowerCase();

            if (action.equals("sneak")) {
                System.out.println("\nYou successfully sneak past the dragon and find a treasure chest.");
                System.out.println("Congratulations, " + playerName + "! You have completed the quest!");
            } else if (action.equals("slay")) {
                System.out.println("\nYou wake the dragon, and it breathes fire at you!");
                System.out.println("Unfortunately, you did not survive. Game over.");
            } else {
                System.out.println("\nInvalid choice. The dragon wakes up, and you become its snack. Game over.");
            }

        } else {
            System.out.println("\nYou decline the quest. The village is disappointed, and you live a quiet life. The end.");
        }

        scanner.close();
    }
}
