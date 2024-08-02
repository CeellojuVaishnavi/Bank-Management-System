package Bank;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankManagementSystem {
    private static Map<String, BankAccount> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Bank Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Account Details");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    handleWithdraw();
                    break;
                case 4:
                    handleViewDetails();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void createAccount() {
        String accountNumber;
        do {
            System.out.print("Enter account number: ");
            accountNumber = scanner.nextLine();
            if (accounts.containsKey(accountNumber)) {
                System.out.println("Account number already taken. Please enter a different account number.");
            }
        } while (accounts.containsKey(accountNumber));
        
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial deposit: ");
        double deposit = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        BankAccount newAccount = new BankAccount(accountNumber, name, deposit, password);
        accounts.put(accountNumber, newAccount);
        System.out.println("Account created successfully.");
    }

    private static void handleDeposit() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        BankAccount account = accounts.get(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        if (!account.verifyPassword(password)) {
            System.out.println("Invalid password.");
            return;
        }

        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline
        account.deposit(amount, password);
    }

    private static void handleWithdraw() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        BankAccount account = accounts.get(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        if (!account.verifyPassword(password)) {
            System.out.println("Invalid password.");
            return;
        }

        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline
        account.withdraw(amount, password);
    }

    private static void handleViewDetails() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        BankAccount account = accounts.get(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        if (!account.verifyPassword(password)) {
            System.out.println("Invalid password.");
            return;
        }

        account.displayAccountDetails(password);
    }
}

