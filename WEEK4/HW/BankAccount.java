package STEP.WEEK4.HW;
class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;
    BankAccount() { balance=0; }
    BankAccount(String n) { accountHolder=n; accountNumber=(int)(Math.random()*10000); }
    BankAccount(String n,double b) { accountHolder=n; balance=b; accountNumber=(int)(Math.random()*10000); }
    void deposit(double a) { balance+=a; }
    void withdraw(double a) { if(balance>=a) balance-=a; }
    void displayAccount() { System.out.println(accountHolder+" "+accountNumber+" "+balance); }
    public static void main(String[] args) {
        BankAccount a=new BankAccount("Alice",500); a.deposit(200); a.displayAccount();
        BankAccount b=new BankAccount("Bob"); b.withdraw(100); b.displayAccount();
    }
}

