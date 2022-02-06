package ru.job4j.bank;

import java.util.*;

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
     *
     * @param user - пользователь.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый счет к пользователю.
     * Первоначально нужно найте пользователя по паспорту {@link #findByPassport(String)}
     * Если клиент найден, то получаем список всех его счетов и добавляем новый.
     *
     * @param passport - данные паспорта
     * @param account  - список счетов
     */
    public void addAccount(String passport, Account account) {
        Optional<User> client = findByPassport(passport);
        if (client.isPresent()) {
            List<Account> rsl = users.get(client.get());
            if (!rsl.contains(account)) {
                rsl.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     *
     * @param passport - номер паспорта
     * @return возвращает пользователя по номеру паспорта, если пользователь не найден возвращает null.
     */
    public Optional<User> findByPassport(String passport) {
                return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();

    }



    /**
     * Метод ищет счет пользователя через номер реквизита
     * В этом методе выполняется поиск пользователя по пасорту {@link #findByPassport(String)}
     * Если пользователь найден,получить список счетов этого пользователя и в нем найти нужный счет
     * @param passport - данные паспорта
     * @param requisite - данные реквизитов
     * @return - возвращает счет пользователя
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> rsl = Optional.empty();
        Optional<User> client = findByPassport(passport);
        if (client.isPresent()) {
            return users.get(client.get())
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst();
        }
        return rsl;
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent() && srcAccount.get().getBalance() >= amount) {
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}


