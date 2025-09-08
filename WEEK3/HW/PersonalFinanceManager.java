//import java.util.*;

class PersonalAccount {
    // Private attributes
    private String accountHolderName;
    private String accountNumber;
    private double currentBalance;
    private double totalIncome;
    private double totalExpenses;

    // Static attributes
    private static int totalAccounts = 0;
    private static String bankName = "Default Bank";

    // Constructor
    public PersonalAccount(String accountHolderName) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = generateAccountNumber();
        this.currentBalance = 0.0;
        this.totalIncome = 0.0;
        this.totalExpenses = 0.0;
        totalAccounts++;
    }

    // Instance methods
    public void addIncome(double amount, String description) {
        if (amount > 0) {
            currentBalance += amount;
            totalIncome += amount;
            System.out.println(accountHolderName + " received income: " + description + " | Amount: " + amount);
        } else {
            System.out.println("Invalid income amount!");
        }
    }

    public void addExpense(double amount, String description) {
        if (amount > 0 && amount <= currentBalance) {
            currentBalance -= amount;
            totalExpenses += amount;
            System.out.println(accountHolderName + " spent on: " + description + " | Amount: " + amount);
        } else {
            System.out.println("Invalid or Insufficient balance for expense!");
        }
    }

    public double calculateSavings() {
        return totalIncome - totalExpenses;
    }

    public void displayAccountSummary() {
        System.out.println("\n--- Account Summary ---");
        System.out.println("Bank Name       : " + bankName);
        System.out.println("Account Holder  : " + accountHolderName);
        System.out.println("Account Number  : " + accountNumber);
        System.out.println("Total Income    : " + totalIncome);
        System.out.println("Total Expenses  : " + totalExpenses);
        System.out.println("Current Balance : " + currentBalance);
        System.out.println("Savings         : " + calculateSavings());
    }

    // Static methods
    public static void setBankName(String name) {
        bankName = name;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static String generateAccountNumber() {
        return "AC" + (1000 + totalAccounts + 1);
    }
}

public class PersonalFinanceManager {
    public static void main(String[] args) {
        // Set Bank Name (shared across all accounts)
        PersonalAccount.setBankName("SRM National Bank");

        // Create accounts
        PersonalAccount acc1 = new PersonalAccount("Alice");
        PersonalAccount acc2 = new PersonalAccount("Bob");
        PersonalAccount acc3 = new PersonalAccount("Charlie");

        // Perform transactions
        acc1.addIncome(5000, "Salary");
        acc1.addExpense(1500, "Rent");

        acc2.addIncome(3000, "Freelancing");
        acc2.addExpense(800, "Groceries");

        acc3.addIncome(7000, "Business Profit");
        acc3.addExpense(2000, "Travel");

        // Display account summaries
        acc1.displayAccountSummary();
        acc2.displayAccountSummary();
        acc3.displayAccountSummary();

        // Show total accounts and shared bank name
        System.out.println("\nTotal Accounts Created: " + PersonalAccount.getTotalAccounts());
        System.out.println("Bank Name (shared): " + "SRM National Bank");
    }
}
