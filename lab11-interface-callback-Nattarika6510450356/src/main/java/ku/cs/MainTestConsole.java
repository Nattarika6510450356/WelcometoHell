package ku.cs;

import ku.cs.models.BankAccount;
import ku.cs.models.StudentList;
import ku.cs.services.StudentIdComparator;
import ku.cs.services.StudentNameComparator;
import ku.cs.services.StudentScoreComparator;
import ku.cs.services.StudentWalletComparator;

public class MainTestConsole {
    public static void main(String[] args) {
        StudentList students = new StudentList();
        students.addNewStudent("61XXXXXXXX", "s1", 50);
        students.addNewStudent("62XXXXXXXX", "s2", 80.12);
        students.addNewStudent("63XXXXXXXX", "s3", 99.99);
        students.addNewStudent("64XXXXXXXX", "s4", 0.01);
        students.addNewStudent("65XXXXXXXX", "s5", 75);


        BankAccount b = new BankAccount("1", "test", 1000000);
        students.findStudentById("64XXXXXXXX").getWallet().addMoneyToWallet(b, 1000);
        students.findStudentById("65XXXXXXXX").getWallet().addMoneyToWallet(b, 20000);
        students.findStudentById("61XXXXXXXX").getWallet().addMoneyToWallet(b, 200);
        students.findStudentById("62XXXXXXXX").getWallet().addMoneyToWallet(b, 100000);
        students.findStudentById("63XXXXXXXX").getWallet().addMoneyToWallet(b, 500);

        System.out.println(students.max());
        System.out.println(students.max(new StudentScoreComparator()));
        System.out.println(students.max(new StudentWalletComparator()));
        System.out.println(students.max(new StudentNameComparator()));
        System.out.println(students.max(new StudentIdComparator()));

    }
}

