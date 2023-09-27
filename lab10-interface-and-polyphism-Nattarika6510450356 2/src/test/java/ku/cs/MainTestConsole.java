package ku.cs;

import ku.cs.models.Student;
import ku.cs.models.StudentList;

import static org.junit.jupiter.api.Assertions.*;

class MainTestConsole {
    public static void main(String[] args){
        // แสดงให้เห็นว่า findStudentById ต่่างจาก findStudentByObject
        // อย่างไร
        StudentList s;
        s = new StudentList();
        s.addNewStudent("1234", "Lisa");
        s.addNewStudent("1234","Love");

        Student findById = s.findStudentById("1234");
        System.out.println(findById);

        Student findByObject = s.findStudentByObject(s.findStudentById("1234"));
        System.out.println(findByObject);

    }

}