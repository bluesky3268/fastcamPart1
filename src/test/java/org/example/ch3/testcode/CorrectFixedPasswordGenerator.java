package org.example.ch3.testcode;

public class CorrectFixedPasswordGenerator implements PasswordGeneratePolicy {
    @Override
    public String generatePassword() {
        return "abcdefgh"; // 8자
    }
}
