class OverLimitException extends Exception {
    public OverLimitException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class Account {
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public synchronized void withdraw(double amount) throws OverLimitException, InsufficientBalanceException {
        if (amount > 15000) {
            throw new OverLimitException("Withdrawal amount exceeds the limit of Rs. 15000.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance for the withdrawal amount.");
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
    }

    public static void main(String[] args) {
        Account myAccount = new Account(10000);

        try {
            myAccount.deposit(5000);
            myAccount.withdraw(2000);
            myAccount.withdraw(16000);  // This should throw OverLimitException
        } catch (OverLimitException e) {
            System.err.println(e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.err.println(e.getMessage());
        }

        try {
            myAccount.withdraw(5000);  // This should throw InsufficientBalanceException
        } catch (OverLimitException e) {
            System.err.println(e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.err.println(e.getMessage());
        }
    }
}
