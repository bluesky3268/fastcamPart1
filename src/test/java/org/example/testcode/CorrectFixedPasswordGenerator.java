package org.example.testcode;

import org.example.testcode.PasswordGeneratePolicy;

public class CorrectFixedPasswordGenerator implements PasswordGeneratePolicy {
    @Override
    public String generatePassword() {
        return "abcdefgh"; // 8자
    }
}
