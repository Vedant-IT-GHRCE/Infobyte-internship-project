package atm;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<String, Account> accounts = new HashMap<>();

    public Bank() {
        // Pre-loaded demo accounts
        accounts.put("1001", new Account("1001", "1234", "Ravi Sharma",  50000.00));
        accounts.put("1002", new Account("1002", "5678", "Priya Mehta",  25000.00));
        accounts.put("1003", new Account("1003", "9999", "Amit Kumar",  100000.00));
    }

    public Account findAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}
