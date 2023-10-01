package ku.cs.services;

import ku.cs.models.Student;
import java.util.Comparator;

public class StudentWalletComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return (int) (o1.getWallet().getBalance() - o2.getWallet().getBalance());
    }
}