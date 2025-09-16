class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccount {
    int depositTerm; // in months

    FixedDepositAccount(String accountNumber, double balance, int depositTerm) {
        super(accountNumber, balance);
        this.depositTerm = depositTerm;
    }

    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("Deposit Term: " + depositTerm + " months");
    }
}

public class BankSystem {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA123", 5000.00, 3.5);
        CheckingAccount checking = new CheckingAccount("CA456", 3000.00, 1000.00);
        FixedDepositAccount fixed = new FixedDepositAccount("FD789", 10000.00, 12);

        savings.displayAccountType();
        System.out.println();
        checking.displayAccountType();
        System.out.println();
        fixed.displayAccountType();
    }
}
