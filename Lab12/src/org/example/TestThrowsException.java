package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestThrowsException {
    public void testThrows() {
        try {
            FileReader reader = new FileReader("file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
    private double balance;
    public void deposit(double amount) {
        if (amount < 0) {
            throw new InsufficientBalanceException("Negative amount");
        }
        balance += amount;
    }
}