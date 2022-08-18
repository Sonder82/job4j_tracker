package ru.job4j.early;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void checkAtNull() {
        PasswordValidator pv = new PasswordValidator();
        assertThatThrownBy(() -> pv.validate(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null");
    }

    @Test
    void checkAtLength() {
        PasswordValidator pv = new PasswordValidator();
        assertThatThrownBy(() -> pv.validate("first"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("length");
    }

    @Test
    void checkAtUpperCase() {
        PasswordValidator pv = new PasswordValidator();
        assertThatThrownBy(() -> pv.validate("VALIDATOR"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Uppercase");
    }

    @Test
    void checkAtLowerCase() {
        PasswordValidator pv = new PasswordValidator();
        assertThatThrownBy(() -> pv.validate("vaLIDATOR"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Lowercase");
    }

    @Test
    void checkAtDigit() {
        PasswordValidator pv = new PasswordValidator();
        assertThatThrownBy(() -> pv.validate("1VALIDATOR"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Digital");
    }

    @Test
    void checkAtSpecial() {
        PasswordValidator pv = new PasswordValidator();
        assertThatThrownBy(() -> pv.validate("@VALIDATOR"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Special");
    }

    @Test
    void checkAtMultiple() {
        PasswordValidator pv = new PasswordValidator();
        assertThatThrownBy(() -> pv.validate("password1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("multiple");
    }
}