package org.example.testcode;

import org.example.testcode.PasswordGeneratePolicy;

public class IncorrectFixedPasswordGenerator implements PasswordGeneratePolicy {
    @Override
    public String generatePassword() {
        return "a"; // 1자
    }
}
