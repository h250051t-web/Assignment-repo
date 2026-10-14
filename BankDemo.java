import java.util.ArrayList;
import java.util.List;

public class BankDemo {

    public static void main(String[] args) {

        List<Account> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("S001", 500.00, 100.00));
        accounts.add(new CurrentAccount("C001", 500.00, 300.00));

        System.out.println("===== BANK ACCOUNT DEMO =====");

        for (Account account : accounts) {

            System.out.println("\nAccount: " + account.accountNumber);
            System.out.println("Starting balance: $" + account.getBalance());

            account.withdraw(600);

            System.out.println("Balance after withdrawal: $"
                    + account.getBalance());

            account.endOfMonth();

            System.out.println("Balance after month-end: $"
                    + account.getBalance());
        }

        System.out.println("\n===== EDGE CASES =====");

        Account savings = new SavingsAccount("S002", 500.00, 100.00);

        System.out.println("\nSavings account test:");
        savings.withdraw(450);
        System.out.println("Balance: $" + savings.getBalance());

        Account current = new CurrentAccount("C002", 500.00, 300.00);

        System.out.println("\nCurrent account overdraft test:");
        current.withdraw(600);
        System.out.println("Balance: $" + current.getBalance());
    }
}