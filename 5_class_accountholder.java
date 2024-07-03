class AccountHolder {
    // Instance variables
    private int accountNumber;
    private String accountHolderName;
    private double accountBalance;
    
    // Constructor
    public AccountHolder(int accountNumber, String accountHolderName, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
    }
    
    // Getter and Setter methods
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
    public double getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void deposit(double amount) {
        accountBalance += amount;
        System.out.println("Deposit of $" + amount + " successful.");
    }
    
    public void withdraw(double amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Withdrawal of " + amount + " successful.");
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }
    
    public static void main(String[] args) {
        // Array of AccountHolder 
        AccountHolder[] accounts = new AccountHolder[3];
        //1.Add record for account holder 
        accounts[0] = new AccountHolder(1001, "khushi", 1500.0);
        accounts[1] = new AccountHolder(1002, "aastha", 2500.0);
        accounts[2] = new AccountHolder(1003, "akshit", 3500.0);
        //2.Display details of all account holders. 
        System.out.println("\nDetail of all account :");
        for (AccountHolder account : accounts) {
            System.out.println("Account Holder: " + account.getAccountHolderName());
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Balance: $" + account.getAccountBalance());
            System.out.println();
        //3.Deposit and Withdraw an amount into particular account 
        System.out.println("\nDetail of Deposit and Withdraw account :");
        accounts[0].deposit(500.0);
        accounts[1].withdraw(1000.0);
        accounts[2].deposit(2000.0);
        
        System.out.println("\nFinal Detail of all account :");
        for (AccountHolder account : accounts) {
            System.out.println("Account Holder: " + account.getAccountHolderName());
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Balance: $" + account.getAccountBalance());
            System.out.println();
        }
    }
}
