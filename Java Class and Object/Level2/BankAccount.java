package com.bridgelabz.oops.leveltwo;

public class BankAccount {
    // Attributes
    private String accountHolder;
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to display bank name
    public static void displayBank() {
        System.out.println("\t\t\t\tState of Chennai\t\t\t\t");
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited: ₹%.2f\n", amount);
        } else {
            System.out.println("Amount to deposit must be positive");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
            System.out.printf("Withdrawn: ₹%.2f\n", amount);
        } else if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive");
        } else {
            System.out.println("Insufficient balance");
        }
    }

    // Method to display balance
    public void displayBalance() {
        System.out.printf("Current balance: ₹%.2f\n", balance);
    }

    // Optional: Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        displayBalance();
    }

    // Main method
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Lynda", "123456789", 700.00);

        displayBank();

        // Display account details
        account.displayAccountDetails();

        // Transactions
        account.deposit(200.00);
        account.displayBalance();

        account.withdraw(100.00);
        account.displayBalance();

        account.withdraw(900.00); // Should trigger "Insufficient balance"
    }
}
