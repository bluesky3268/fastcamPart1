package org.example;

public class IncorrectFixedPasswordGenerator implements PasswordGeneratePolicy{
    @Override
    public String generatePassword() {
        return "a"; // 1자
    }
}
