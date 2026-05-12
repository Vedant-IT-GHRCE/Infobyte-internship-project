package atm;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<String, Account> accounts = new HashMap<>();

    public Bank() {
        // Pre-loaded demo accounts
        accounts.put("0121", new Account("1001", "2006", "Vedant Raut",  25000.00));
        accounts.put("0122", new Account("1002", "1985", "Hemraj Raut",  100000.00));
        accounts.put("0123", new Account("1003", "1990", "Sushma Raut",  50000.00));
    }

    public Account findAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}
