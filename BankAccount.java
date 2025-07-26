import java.util.Scanner;

public class BankAccount {
    private int balance;
    private int previousTransaction;
    private final String customerID;
    private final String password;

    public BankAccount(String customerID, int balance, int previousTransaction, String password) {
        this.customerID = customerID;
        this.balance = balance;
        this.previousTransaction = previousTransaction;
        this.password = password;
    }

    public String getCustomerID() { return customerID; }
    public String getPassword() { return password; }
    public int getBalance() { return balance; }
    public int getPreviousTransaction() { return previousTransaction; }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            previousTransaction = -amount;
        } else {
            System.out.println("Insufficient funds or invalid input.");
        }
    }

    public void getPreviousTransactionDetails() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: Rs" + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: Rs" + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction yet.");
        }
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        char option;

        do {
            System.out.println("\nA. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous Transaction");
            System.out.println("E. Exit");

            System.out.print("Choose an option: ");
            option = sc.next().charAt(0);
            option = Character.toUpperCase(option);

            switch (option) {
                case 'A':
                    System.out.println("Balance: ₹" + balance);
                    break;
                case 'B':
                    System.out.print("Enter amount to deposit: ");
                    deposit(sc.nextInt());
                    break;
                case 'C':
                    System.out.print("Enter amount to withdraw: ");
                    withdraw(sc.nextInt());
                    break;
                case 'D':
                    getPreviousTransactionDetails();
                    break;
                case 'E':
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 'E');

    }
}
