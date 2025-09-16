import java.util.ArrayList;

class Customer {
    String name;
    ArrayList<BankAccount> accounts;

    Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    void addAccount(BankAccount account) {
        accounts.add(account);
    }

    void viewBalance() {
        System.out.println("Accounts for " + name + ":");
        if (accounts.isEmpty()) {
