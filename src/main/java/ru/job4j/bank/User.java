package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает работу модели пользователя банка.
 * Эта модель содержит поля: паспорт и имя пользователя.
 * @author Aleksey Novoselov
 * @version 1.0
 */
public class User {

    /**
     * Поле номер паспорта
     */
    private String passport;

    /**
     * Поле имя пользователя
     */
    private String username;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param passport - номер паспорта
     * @param username - имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Функция получения значения поля {@link User#passport}
     * @return возвращает номер паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Процедура определения номера паспорта {@link User#passport}
     * @param passport - номер паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Функция получения значения поля {@link User#username}
     * @return возвращает имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Процедура определения значения имя пользователя {@link User#username}
     * @param username - имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport) && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport, username);
    }
}
