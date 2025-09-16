class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double amount) {
        if (amount >= 0) {
            balance = amount;
        }
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    void displayAccountDetails() {
        // Accessing public accountNumber directly
        System.out.println("Account Number: " + accountNumber);
        // Accessing protected accountHolder directly
        System.out.println("Account Holder: " + accountHolder);
        // Accessing private balance via public getter
        System.out.println("Balance: $" + getBalance());
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

public class BankAccountManagement {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("ACC123", "Alice Johnson", 5000, 3.5);
        sa.displayAccountDetails();

        sa.setBalance(5500);
        System.out.println("Updated Balance: $" + sa.getBalance());
    }
}
