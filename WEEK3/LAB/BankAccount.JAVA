import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    private static int totalAccounts = 0;
    private static int accountCounter = 0;

    // Constructor
    public BankAccount(String accountHolderName, double initialDeposit) {
        if (initialDeposit < 0) {
            System.out.println("❌ Initial deposit cannot be negative. Setting balance to 0.");
            initialDeposit = 0;
        }

        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber();
        totalAccounts++;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Deposit amount must be positive.");
        } else {
            balance += amount;
            System.out.println("✅ Deposited " + amount + " to " + accountNumber);
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance in " + accountNumber);
        } else {
            balance -= amount;
            System.out.println("✅ Withdrawn " + amount + " from " + accountNumber);
        }
    }

    // Check balance
    public void checkBalance() {
        System.out.println("💰 Balance for " + accountNumber + ": " + balance);
    }

    // Display account info
    public void displayAccountInfo() {
        System.out.println("------------------------------");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Balance        : " + balance);
        System.out.println("------------------------------");
    }

    // Generate unique account number
    public static String generateAccountNumber() {
        accountCounter++;
        return String.format("ACC%03d", accountCounter);
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

public class BankManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankAccount[] accounts = new BankAccount[10]; // max 10 accounts
        int accountCount = 0;

        while (true) {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Info");
            System.out.println("6. Show Total Accounts");
            System.out.println("7. Exit");
            System.out.print("👉 Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    if (accountCount < accounts.length) {
                        System.out.print("Enter Account Holder Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Initial Deposit: ");
                        double deposit = sc.nextDouble();
                        accounts[accountCount] = new BankAccount(name, deposit);
                        System.out.println("✅ Account created successfully!");
                        accountCount++;
                    } else {
                        System.out.println("❌ Account limit reached.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    String accNoDep = sc.nextLine();
                    BankAccount accDep = findAccount(accounts, accNoDep, accountCount);
                    if (accDep != null) {
                        System.out.print("Enter Amount to Deposit: ");
                        double amount = sc.nextDouble();
                        accDep.deposit(amount);
                    } else {
                        System.out.println("❌ Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    String accNoWit = sc.nextLine();
                    BankAccount accWit = findAccount(accounts, accNoWit, accountCount);
                    if (accWit != null) {
                        System.out.print("Enter Amount to Withdraw: ");
                        double amount = sc.nextDouble();
                        accWit.withdraw(amount);
                    } else {
                        System.out.println("❌ Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    String accNoBal = sc.nextLine();
                    BankAccount accBal = findAccount(accounts, accNoBal, accountCount);
                    if (accBal != null) {
                        accBal.checkBalance();
                    } else {
                        System.out.println("❌ Account not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    String accNoInfo = sc.nextLine();
                    BankAccount accInfo = findAccount(accounts, accNoInfo, accountCount);
                    if (accInfo != null) {
                        accInfo.displayAccountInfo();
                    } else {
                        System.out.println("❌ Account not found.");
                    }
                    break;

                case 6:
                    System.out.println("✅ Total accounts created: " + BankAccount.getTotalAccounts());
                    break;

                case 7:
                    System.out.println("👋 Thank you for using the Bank System. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }

    
    public static BankAccount findAccount(BankAccount[] accounts, String accNo, int count) {
        for (int i = 0; i < count; i++) {
            if (accounts[i] != null && accounts[i].getAccountNumber().equals(accNo)) {
                return accounts[i];
            }
        }
        return null;
    }
}
