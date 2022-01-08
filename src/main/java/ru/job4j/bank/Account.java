package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает работу модели банковского счета.
 * Эта модель содержит поля: баланс и реквизиты.
 * @author Aleksey Novoselov
 * @version 1.0
 */
public class Account {

    /**
     * Поле реквизиты
     */
    private String requisite;

    /**
     * Поле баланс
     */
    private double balance;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param requisite - реквизит
     * @param balance - баланс
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Функция получения значения поля {@link Account#requisite}
     * @return возвращает наименование реквизита
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Процедура определения реквизита {@link Account#requisite}
     * @param requisite - реквизит
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Функция получения значения поля {@link Account#balance}
     * @return возвращает баланс
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Процедура определения баланса {@link Account#balance}
     * @param balance - баланс
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Double.compare(account.balance, balance) == 0 && Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite, balance);
    }
}

