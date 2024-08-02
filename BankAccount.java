package Bank;
    public class BankAccount {
        private String accountNumber;
        private String accountHolderName;
        private double balance;
        private String password; 
    
        public BankAccount(String accountNumber, String accountHolderName, double initialDeposit, String password) {
            this.accountNumber = accountNumber;
            this.accountHolderName = accountHolderName;
            this.balance = initialDeposit;
            this.password = password;
        }
    
        public boolean verifyPassword(String inputPassword) {
            return this.password.equals(inputPassword);
        }
    
        public void deposit(double amount, String password) {
            if (verifyPassword(password)) {
                balance += amount;
                System.out.println("Deposited: $" + amount);
            } else {
                System.out.println("Invalid password.");
            }
        }
    
        public void withdraw(double amount, String password) {
            if (verifyPassword(password)) {
                if (amount > balance) {
                    System.out.println("Insufficient funds.");
                } else {
                    balance -= amount;
                    System.out.println("Withdrew: $" + amount);
                }
            } else {
                System.out.println("Invalid password.");
            }
        }
    
        public void displayAccountDetails(String password) {
            if (verifyPassword(password)) {
                System.out.println("Account Number: " + accountNumber);
                System.out.println("Account Holder: " + accountHolderName);
                System.out.println("Balance: $" + balance);
            } else {
                System.out.println("Invalid password.");
            }
        }
    
        public String getAccountNumber() {
            return accountNumber;
        }
    }
    

