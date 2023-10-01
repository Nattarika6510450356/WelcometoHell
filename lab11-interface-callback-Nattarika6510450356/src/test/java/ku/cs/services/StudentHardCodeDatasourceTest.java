package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {

    @Test
    void testReadData(){
        StudentHardCodeDatasource datasource = new StudentHardCodeDatasource();
        StudentList studentList = datasource.readData();

        assertNotNull(studentList); // ตรวจสอบว่ารายชื่อ student ไม่เป็น null

        Student s1 = studentList.findStudentById("6410400001");
        assertNotNull(s1);
        assertEquals("6410400001", s1.getId());
        assertEquals("First", s1.getName());

        Student s2 = studentList.findStudentById("6410400002");
        assertNotNull(s2);
        assertEquals("6410400002", s2.getId());
        assertEquals("Second", s2.getName());

        Student s3 = studentList.findStudentById("6410400003");
        assertNotNull(s3);
        assertEquals("6410400003", s3.getId());
        assertEquals("Third", s3.getName());

        Student s4 = studentList.findStudentById("6410400004");
        assertNotNull(s4);
        assertEquals("6410400004", s4.getId());
        assertEquals("Fourth", s4.getName());

    }

}