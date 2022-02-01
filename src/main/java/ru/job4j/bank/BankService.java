package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса
 * @author Aleksey Novoselov
 * @version 1.0
 */
public class BankService {

    /**
     * Хранение счетов пользователей осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает один параметр: пользователя.
     * Метод проверяет есть ли пользователь в системе.
     * Если пользователя нет в системе, то он добавляет его
     * @param user - пользователь.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый счет к пользователю.
     * Первоначально нужно найте пользователя по паспорту {@link #findByPassport(String)}
     * Если клиент найден, то получаем список всех его счетов и добавляем новый.
     * @param passport - данные паспорта
     * @param account - список счетов
     */
    public void addAccount(String passport, Account account) {
        User client = findByPassport(passport);
        if (client != null) {
            List<Account> rsl = users.get(client);
            if (!rsl.contains(account)) {
                rsl.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     * @param passport - номер паспорта
     * @return возвращает пользователя по номеру паспорта, если пользователь не найден возвращает null.
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);

    }

    /**
     * Метод ищет счет пользователя через номер реквизита
     * В этом методе выполняется поиск пользователя по пасорту {@link #findByPassport(String)}
     * Если пользователь найден,получить список счетов этого пользователя и в нем найти нужный счет
     * @param passport - данные паспорта
     * @param requisite - данные реквизитов
     * @return - возвращает счет пользователя
     */
    public Account findByRequisite(String passport, String requisite) {
        User client = findByPassport(passport);
        if (client != null) {
            return users.get(client)
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт
     * @param srcPassport - номер паспорта отправителя
     * @param srcRequisite - реквизиты счета отправителя
     * @param destPassport - номер паспорта получателя
     * @param destRequisite реквизиты счета получателя
     * @param amount - сумма перевода
     * @return возвращает истину, если данные паспортов и реквизитов найдены,
     * и денег на счете отправителя достаточно для суммы перевода
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            destAccount.setBalance(destAccount.getBalance() + amount);
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}


