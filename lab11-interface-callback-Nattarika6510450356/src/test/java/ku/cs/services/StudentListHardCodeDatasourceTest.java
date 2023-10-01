package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListHardCodeDatasourceTest {

    @Test
    public void testReadData() {
        StudentListHardCodeDatasource datasource = new StudentListHardCodeDatasource();
        StudentList studentList = datasource.readData();
        Student s = studentList.findStudentById("6410400001");
        assertNotNull(s);
        assertEquals("First",s.getName());
    }

}