package ru.job4j.collection;

import java.util.Objects;

public class Citizen {
    private String passport;
    private String userName;

    public Citizen(String passport, String userName) {
        this.passport = passport;
        this.userName = userName;
    }

    public String getPassport() {
        return passport;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Citizen citizen = (Citizen) obj;
        return Objects.equals(passport, citizen.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
