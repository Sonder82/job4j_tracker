package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        List<Account> rsl = users.get(findByPassport(passport));
        if (!rsl.contains(account)) {
            rsl.add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        if (findByPassport(passport) != null) {
            List<Account> rsl = users.get(findByPassport(passport));
            for (Account account : rsl) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
            return null;
        }


    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        List<Account> srcAccount = users.get(findByPassport(srcPassport));
        Account destAccount = findByRequisite(destPassport, destRequisite);
        for (Account account : srcAccount) {
          if (srcAccount.contains(findByRequisite(srcPassport, srcRequisite)) && account.getBalance() >= amount) {
           destAccount.setBalance(destAccount.getBalance() + amount);
                rsl = true;
                break;
            }
        }
        return rsl;
    }
}
