public class BankAccount {
    private static String bankName;
    private static int totalAccounts = 0;
    private static double interestRate;

    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        totalAccounts++;
    }

    public static void setBankName(String name) {
        bankName = name;
    }

    public static void setInterestRate(double rate) {
        interestRate = rate;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void displayBankInfo() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Total Accounts: " + totalAccounts);
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println();
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(accountHolder + " deposited " + amount + ". New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew " + amount + ". New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance for " + accountHolder);
        }
    }

    public void calculateInterest() {
        double interest = balance * (interestRate / 100);
        System.out.println("Interest for " + accountHolder + ": " + interest);
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println();
    }

    public static void main(String[] args) {
        BankAccount.setBankName("National Bank");
        BankAccount.setInterestRate(5.0);

        BankAccount acc1 = new BankAccount("A101", "Alice", 1000);
        BankAccount acc2 = new BankAccount("A102", "Bob", 2000);
        BankAccount acc3 = new BankAccount("A103", "Charlie", 500);

        acc1.deposit(500);
        acc2.withdraw(300);
        acc3.deposit(200);

        acc1.calculateInterest();
        acc2.calculateInterest();
        acc3.calculateInterest();

        acc1.displayAccountInfo();
        acc2.displayAccountInfo();
        acc3.displayAccountInfo();

        BankAccount.displayBankInfo();

        System.out.println("Total Accounts (via class): " + BankAccount.getTotalAccounts());
        System.out.println("Total Accounts (via object): " + acc1.getTotalAccounts());
    }
}
