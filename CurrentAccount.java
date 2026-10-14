public class CurrentAccount extends Account {

    private double overdraftLimit;
    private final double monthlyFee = 10.00;

    public CurrentAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Withdrawal rejected: amount must be positive.");

        } else if (balance - amount < -overdraftLimit) {
            System.out.println("Current withdrawal rejected: overdraft limit of $"
                    + overdraftLimit + " exceeded.");

        } else {
            balance -= amount;
            System.out.println("Current withdrawal successful: $" + amount);
        }
    }

    @Override
    public void endOfMonth() {
        balance -= monthlyFee;

        System.out.println("Monthly maintenance fee deducted: $" + monthlyFee);
    }
}