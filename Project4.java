import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenseTracker {

    private static final List<Expense> expenses = new ArrayList<>();
    private static final String FILE_PATH = "expenses.txt";

    public static void main(String[] args) {
        loadDataFromFile();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Expense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Expense Summaries");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addExpense(scanner);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    expenseSummaries(scanner);
                    break;
                case 4:
                    saveDataToFile();
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private static void addExpense(Scanner scanner) {
        System.out.print("Enter expense description: ");
        String description = scanner.nextLine();

        System.out.print("Enter expense amount: ");
        double amount = validateDoubleInput(scanner);

        System.out.print("Enter expense category: ");
        String category = scanner.nextLine();

        Expense expense = new Expense(description, amount, category);
        expenses.add(expense);

        System.out.println("Expense added successfully!");
    }

    private static void viewExpenses() {
        System.out.println("Expense List:");
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    private static void expenseSummaries(Scanner scanner) {
        System.out.println("Expense Summaries Menu:");
        System.out.println("1. Total Expenses");
        System.out.println("2. Expenses by Category");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                double totalExpenses = expenses.stream().mapToDouble(Expense::getAmount).sum();
                System.out.println("Total Expenses: $" + totalExpenses);
                break;
            case 2:
                System.out.println("Category-wise Expenses:");
                expenses.stream()
                        .collect(java.util.stream.Collectors.groupingBy(Expense::getCategory))
                        .forEach((category, expList) -> {
                            double totalCategoryExpenses = expList.stream().mapToDouble(Expense::getAmount).sum();
                            System.out.println(category + ": $" + totalCategoryExpenses);
                        });
                break;
            default:
                System.out.println("Invalid choice. Please enter 1 or 2.");
        }
    }

    private static double validateDoubleInput(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }

    private static void saveDataToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(expenses);
            System.out.println("Data saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static void loadDataFromFile() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
                expenses.addAll((List<Expense>) ois.readObject());
                System.out.println("Data loaded from file.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading data from file: " + e.getMessage());
            }
        }
    }
}

class Expense implements Serializable {
    private final String description;
    private final double amount;
    private final String category;

    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Description: " + description + ", Amount: $" + amount + ", Category: " + category;
    }
}
