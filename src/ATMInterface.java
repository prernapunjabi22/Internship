import java.util.Scanner;

class Account {
    private String userId;
    private String userPin;
    private double balance;

    public Account(String userId, String userPin, double initialBalance) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = initialBalance;
    }

    public boolean authenticate(String userId, String userPin) {
        return this.userId.equals(userId) && this.userPin.equals(userPin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void transfer(Account recipient, double amount) {
        if (amount <= balance) {
            balance -= amount;
            recipient.deposit(amount);
            System.out.println("Transfer successful");
        } else {
            System.out.println("Insufficient balance for transfer");
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Account account = new Account("user123", "1234", 1000.0);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter User PIN: ");
        String userPin = scanner.nextLine();

        if (account.authenticate(userId, userPin)) {
            System.out.println("Authentication successful.");
            while (true) {
                System.out.println("Choose an option:");
                System.out.println("1. View Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Balance: $" + account.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        System.out.println("Deposit successful.");
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;
                    case 4:
                        System.out.print("Enter recipient's User ID: ");
                        String recipientId = scanner.next();
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        // Simulating transfer to another account (you need account validation logic here)
                        Account recipient = new Account("recipient123", "5678", 0.0);
                        account.transfer(recipient, transferAmount);
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM.");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } else {
            System.out.println("Authentication failed. Exiting...");
        }
    }
}