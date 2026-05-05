package atm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String type;       // DEPOSIT, WITHDRAW, BALANCE
    private double amount;
    private double balanceAfter;
    private String timestamp;

    public Transaction(String type, double amount, double balanceAfter) {
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    @Override
    public String toString() {
        if (type.equals("BALANCE")) {
            return String.format("[%s]  %-10s  Balance: Rs %.2f", timestamp, type, balanceAfter);
        }
        return String.format("[%s]  %-10s  Amount: Rs %.2f  |  Balance: Rs %.2f",
                timestamp, type, amount, balanceAfter);
    }
}
