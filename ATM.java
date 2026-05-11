package atm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {

    private Bank bank;
    private Account currentAccount;
    private List<Transaction> transactionHistory;
    private Scanner scanner;

    private static final int MAX_PIN_ATTEMPTS = 3;

    public ATM(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
        this.transactionHistory = new ArrayList<>();
    }

    
    public void start() {
        printWelcomeBanner();

        while (true) {
            if (login()) {
                showMenu();
            }

            System.out.print("\n  Use another account? (yes/no): ");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (!choice.equals("yes")) break;
        }

        printGoodbye();
        scanner.close();
    }

    
    private boolean login() {
        System.out.print("\n  Enter Account Number: ");
        String accNo = scanner.nextLine().trim();

        Account account = bank.findAccount(accNo);
        if (account == null) {
            System.out.println("  ✗ Account not found.");
            return false;
        }

        for (int attempt = 1; attempt <= MAX_PIN_ATTEMPTS; attempt++) {
            System.out.print("  Enter PIN: ");
            String pin = scanner.nextLine().trim();

            if (account.validatePin(pin)) {
                currentAccount = account;
                transactionHistory = new ArrayList<>();
                System.out.println("\n  ✓ Welcome, " + currentAccount.getHolderName() + "!");
                return true;
            } else {
                int remaining = MAX_PIN_ATTEMPTS - attempt;
                if (remaining > 0)
                    System.out.println("  ✗ Wrong PIN. " + remaining + " attempt(s) left.");
                else
                    System.out.println("  ✗ Card blocked. Too many wrong attempts.");
            }
        }
        return false;
    }

    
    private void showMenu() {
        while (true) {
            printMenu();
            System.out.print("  Choose option: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1": checkBalance();    break;
                case "2": deposit();         break;
                case "3": withdraw();        break;
                case "4": miniStatement();   break;
                case "5":
                    System.out.println("\n  Session ended. Card removed.");
                    currentAccount = null;
                    return;
                default:
                    System.out.println("  ✗ Invalid option. Try again.");
            }
        }
    }

    
    private void checkBalance() {
        double bal = currentAccount.getBalance();
        System.out.println("\n  ┌─────────────────────────────────┐");
        System.out.printf ("  │  Available Balance: Rs %-9.2f│%n", bal);
        System.out.println("  └─────────────────────────────────┘");
        transactionHistory.add(new Transaction("BALANCE", 0, bal));
    }

    private void deposit() {
        System.out.print("\n  Enter deposit amount: Rs ");
        double amount = readAmount();
        if (amount <= 0) return;

        if (currentAccount.deposit(amount)) {
            System.out.printf("  ✓ Rs %.2f deposited successfully.%n", amount);
            transactionHistory.add(new Transaction("DEPOSIT", amount, currentAccount.getBalance()));
        } else {
            System.out.println("  ✗ Invalid amount.");
        }
    }

    private void withdraw() {
        System.out.print("\n  Enter withdrawal amount: Rs ");
        double amount = readAmount();
        if (amount <= 0) return;

        if (currentAccount.withdraw(amount)) {
            System.out.printf("  ✓ Please collect Rs %.2f.%n", amount);
            transactionHistory.add(new Transaction("WITHDRAW", amount, currentAccount.getBalance()));
        } else {
            System.out.println("  ✗ Insufficient balance or invalid amount.");
        }
    }

    private void miniStatement() {
        System.out.println("\n  ── Mini Statement ──────────────────────────────────");
        System.out.println("  Account: " + currentAccount.getAccountNumber()
                         + "  |  Holder: " + currentAccount.getHolderName());
        System.out.println("  ────────────────────────────────────────────────────");
        if (transactionHistory.isEmpty()) {
            System.out.println("  No transactions in this session.");
        } else {
            for (Transaction t : transactionHistory) {
                System.out.println("  " + t);
            }
        }
        System.out.println("  ────────────────────────────────────────────────────");
    }

    
    private double readAmount() {
        try {
            double val = Double.parseDouble(scanner.nextLine().trim());
            if (val <= 0) { System.out.println("  ✗ Amount must be greater than zero."); return -1; }
            return val;
        } catch (NumberFormatException e) {
            System.out.println("  ✗ Invalid amount entered.");
            return -1;
        }
    }

    private void printWelcomeBanner() {
        System.out.println();
        System.out.println("  ╔══════════════════════════════════════╗");
        System.out.println("  ║        JAVA ATM MACHINE v1.0         ║");
        System.out.println("  ║     Insert Card to Get Started       ║");
        System.out.println("  ╚══════════════════════════════════════╝");
        System.out.println();
        System.out.println("  Demo Accounts:");
        System.out.println("  Acc: 0121  PIN: 2006  (Vedant Raut)");
        System.out.println("  Acc: 0122  PIN: 1985  (Hemraj Raut)");
        System.out.println("  Acc: 0123  PIN: 1990  (Sushma Raut)");
        System.out.println();
    }

    private void printMenu() {
        System.out.println();
        System.out.println("  ┌──────────────────────────┐");
        System.out.println("  │        ATM MENU          │");
        System.out.println("  ├──────────────────────────┤");
        System.out.println("  │  1. Check Balance        │");
        System.out.println("  │  2. Deposit              │");
        System.out.println("  │  3. Withdraw             │");
        System.out.println("  │  4. Mini Statement       │");
        System.out.println("  │  5. Exit / Eject Card    │");
        System.out.println("  └──────────────────────────┘");
    }

    private void printGoodbye() {
        System.out.println();
        System.out.println("  Thank you for using Java ATM. Goodbye!");
        System.out.println();
    }
}
