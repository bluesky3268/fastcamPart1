package org.example.ch3.testcode;

public class IncorrectFixedPasswordGenerator implements PasswordGeneratePolicy {
    @Override
    public String generatePassword() {
        return "a"; // 1자
    }
}
