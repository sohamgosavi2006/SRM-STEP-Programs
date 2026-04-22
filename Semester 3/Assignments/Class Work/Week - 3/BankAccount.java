public class BankAccount {

    // Static Class members - shared (common) by ALL BankAccount objects 
    private static String bankName = "Unnamed Bank";
    // To keep track of total accounts in Bank
    private static int totalAccounts = 0;
    private static double interestRate = 0.0; // annual rate (e.g., 5.0 means 5%)

    // Instance members - 
    private final String accountNumber;
    private final String accountHolder;
    private double balance;

    // Constructor -
    public BankAccount(String accountNumber, String accountHolder, double openingBalance) {
        if (accountNumber == null || accountNumber.isBlank())
            throw new IllegalArgumentException("accountNumber required");
        if (accountHolder == null || accountHolder.isBlank())
            throw new IllegalArgumentException("accountHolder required");
        if (openingBalance < 0)
            throw new IllegalArgumentException("openingBalance cannot be negative");

        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = openingBalance;
        totalAccounts++; // affects the class-wide counter
    }

    // Static Methods (operate on class-wide data) =====
    public static void setBankName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("bank name required");
        bankName = name;
    }

    public static void setInterestRate(double ratePercent) {
        if (ratePercent < 0) throw new IllegalArgumentException("rate cannot be negative");
        interestRate = ratePercent;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void displayBankInfo() {
        System.out.println("Bank: " + bankName + " | Total Accounts: " + totalAccounts + " | Interest Rate: " + interestRate + "%");
    }

    // Instance methods (operate on per-object data) =====
    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("deposit must be positive");
        balance += amount;
        System.out.println(accountNumber + " deposited " + amount + " | New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("withdrawal must be positive");
        if (amount > balance) throw new IllegalArgumentException("insufficient funds");
        balance -= amount;
        System.out.println(accountNumber + " withdrew " + amount + " | New balance: " + balance);
    }

    public double calculateInterest() {
        return balance * (interestRate / 100.0);
    }

    public void displayAccountInfo() {
        System.out.println("[" + bankName + "] " +
                "Account#" + accountNumber + " | Holder: " + accountHolder +
                " | Balance: " + balance);
    }

    public static void main(String[] args) {
        // Set class-wide data via static methods (no object needed)
        BankAccount.setBankName("Sunrise Bank");
        BankAccount.setInterestRate(4.5);

        // Create multiple accounts (each has unique instance data)
        BankAccount a1 = new BankAccount("SB-1001", "Soham", 5000);
        BankAccount a2 = new BankAccount("SB-1002", "Arjun", 12000);
        BankAccount a3 = new BankAccount("SB-1003", "Maya", 3000);

        // Show class-wide info (shared across all)
        BankAccount.displayBankInfo();

        // Perform instance-specific operations
        a1.deposit(1000);
        a2.withdraw(2000);
        a3.deposit(500);

        // Interest uses the shared static interestRate but is computed on each account's own balance
        System.out.println("a1 yearly interest: " + a1.calculateInterest());
        System.out.println("a2 yearly interest: " + a2.calculateInterest());
        System.out.println("a3 yearly interest: " + a3.calculateInterest());

        // Show per-account info (note the same bankName appears for all because it's static)
        a1.displayAccountInfo();
        a2.displayAccountInfo();
        a3.displayAccountInfo();

        // Demonstrate that static members are shared and accessible via instances (legal but not recommended)
        System.out.println("Total accounts (via class): " + BankAccount.getTotalAccounts());
        System.out.println("Total accounts (via instance): " + a1.getTotalAccounts()); // works, but prefer class

        // Change static data and show it reflects for all objects
        BankAccount.setBankName("Sunrise Bank International");
        BankAccount.displayBankInfo();
        a1.displayAccountInfo(); // bankName changed here too
        a2.displayAccountInfo();
        a3.displayAccountInfo();
    }
}
