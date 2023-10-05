package org.example;

public class Main {
    public static void main(String[] args) {
        TestThrowsException testThrowsException = new TestThrowsException();
        testThrowsException.testThrows();
        try {
            testThrowsException.deposit(-1);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

    }

}