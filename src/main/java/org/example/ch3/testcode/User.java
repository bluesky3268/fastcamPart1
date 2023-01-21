package org.example.ch3.testcode;

public class User {
    private String password;

    public String getPassword() {
        return password;
    }

    public void initPassword(PasswordGeneratePolicy passwordGenerate){
        String password = passwordGenerate.generatePassword();

        if (password.length() >= 8 && password.length() <= 12) {
            this.password = password;
        }
    }
}
