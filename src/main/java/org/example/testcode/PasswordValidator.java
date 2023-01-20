package org.example.testcode;

public class PasswordValidator {
    private static final String WRONG_PASSWORD_LENGTH_MESSAGE = "비밀번호 길이는 8~12자입니다.";
    public static void validate(String password) {
        int length = password.length();
        if (length < 8 || length > 12) {
            throw new IllegalArgumentException(WRONG_PASSWORD_LENGTH_MESSAGE);
        }
    }
}
