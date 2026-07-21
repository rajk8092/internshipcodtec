import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {

    static ArrayList<Expense> expenses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static double income = 0;

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n========== EXPENSE TRACKER ==========");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Expenses");
            System.out.println("4. Dashboard");
            System.out.println("5. Search Category");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addIncome();
                    break;

                case 2:
                    addExpense();
                    break;

                case 3:
                    viewExpenses();
                    break;

                case 4:
                    dashboard();
                    break;

                case 5:
                    searchCategory();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    static void addIncome() {
        System.out.print("Enter Income: ₹");
        income += sc.nextDouble();
        System.out.println("Income Added Successfully.");
    }

    static void addExpense() {

        sc.nextLine();

        System.out.print("Category: ");
        String category = sc.nextLine();

        System.out.print("Amount: ₹");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Date (DD/MM/YYYY): ");
        String date = sc.nextLine();

        expenses.add(new Expense(category, amount, date));

        System.out.println("Expense Added Successfully.");
    }

    static void viewExpenses() {

        if (expenses.isEmpty()) {
            System.out.println("No Expenses Found.");
            return;
        }

        for (Expense e : expenses) {
            System.out.println("----------------------");
            System.out.println(e);
        }
    }

    static void dashboard() {

        double totalExpense = 0;

        for (Expense e : expenses)
            totalExpense += e.getAmount();

        System.out.println("\n========= DASHBOARD =========");
        System.out.println("Total Income  : ₹" + income);
        System.out.println("Total Expense : ₹" + totalExpense);
        System.out.println("Balance       : ₹" + (income - totalExpense));
        System.out.println("Transactions  : " + expenses.size());
    }

    static void searchCategory() {

        System.out.print("Enter Category: ");
        String cat = sc.nextLine();

        boolean found = false;

        for (Expense e : expenses) {

            if (e.getCategory().equalsIgnoreCase(cat)) {

                System.out.println("-------------------");
                System.out.println(e);
                found = true;
            }
        }

        if (!found)
            System.out.println("No Expense Found.");
    }
}