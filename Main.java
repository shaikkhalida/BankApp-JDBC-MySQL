package in.sp.bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Bank Operations ---");
            System.out.println("1. Open a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Display account details");
            System.out.println("5. Delete an account");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Open a new account
                    System.out.print("Enter account holder name: ");
                    scanner.nextLine();  // Consume newline
                    String name = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    BankAccount account = new BankAccount(0, name, initialBalance);
                    BankOperations.openAccount(account);
                    break;

                case 2:
                    // Deposit money into an account
                    System.out.print("Enter account number: ");
                    int accountNumberForDeposit = scanner.nextInt();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    BankOperations.depositMoney(accountNumberForDeposit, depositAmount);
                    break;

                case 3:
                    // Withdraw money from an account
                    System.out.print("Enter account number: ");
                    int accountNumberForWithdraw = scanner.nextInt();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    BankOperations.withdrawMoney(accountNumberForWithdraw, withdrawAmount);
                    break;

                case 4:
                    // Display account details
                    System.out.print("Enter account number: ");
                    int accountNumberForDetails = scanner.nextInt();
                    BankOperations.displayAccountDetails(accountNumberForDetails);
                    break;

                case 5:
                    // Delete an account
                    System.out.print("Enter account number to delete: ");
                    int accountNumberForDelete = scanner.nextInt();
                    BankOperations.deleteAccount(accountNumberForDelete);
                    break;

                case 6:
                    // Exit
                    System.out.println("Thank you for using the banking system!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
