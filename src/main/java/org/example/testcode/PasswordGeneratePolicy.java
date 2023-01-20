package org.example.testcode;

@FunctionalInterface // 함수형 인터페이스는 위에서도 설명했듯이 추상 메서드가 오직 하나인 인터페이스를 의미한다.
public interface PasswordGeneratePolicy {

    String generatePassword();

}
