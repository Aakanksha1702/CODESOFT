import java.util.Scanner;

class BankAccount {
    private double balance;

    // Constructor to initialize the account balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposit successful! New balance: $" + balance);
        } else {
            System.out.println("❌ Invalid deposit amount. Please enter a positive value.");
        }
    }

    // Method to withdraw money
    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("❌ Insufficient balance! Your current balance is: $" + balance);
            return false;
        } else if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount. Please enter a positive value.");
            return false;
        } else {
            balance -= amount;
            System.out.println("✅ Withdrawal successful! New balance: $" + balance);
            return true;
        }
    }

    // Method to check the balance
    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;

    // Constructor to connect the ATM to a BankAccount
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Display the ATM menu
    public void displayMenu() {
        System.out.println("\n--- ATM Interface ---");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    // Start the ATM operations
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();
            System.out.print("Choose an option: ");
            int choice;

            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("❌ Invalid input! Please enter a number between 1 and 4.");
                scanner.next(); // Clear invalid input
                continue;
            }

            switch (choice) {
                case 1: // Check balance
                    System.out.println("💰 Current balance: $" + account.checkBalance());
                    break;

                case 2: // Deposit money
                    System.out.print("Enter the amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3: // Withdraw money
                    System.out.print("Enter the amount to withdraw: $");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;

                case 4: // Exit
                    System.out.println("Thank you for using the ATM! Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("❌ Invalid choice! Please choose a valid option.");
            }
        }

        scanner.close();
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        // Initialize the user's bank account with a starting balance
        BankAccount userAccount = new BankAccount(500.00);

        // Create an ATM instance connected to the user's account
        ATM atm = new ATM(userAccount);

        // Start the ATM interface
        atm.start();
    }
}
