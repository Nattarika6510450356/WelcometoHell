package ku.cs.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentList {
    private ArrayList<Student> students;

    public void addNewStudent(String id, String name) {
        id = id.trim();
        name = name.trim();
        if (!id.isEmpty() && !name.isEmpty()) {
            Student exist = findStudentById(id);
            if (exist == null) {
                students.add(new Student(id, name));
            }
        }
    }

    public void addNewStudent(String id, String name, double score) {
        id = id.trim();
        name = name.trim();
        if (!id.isEmpty() && !name.isEmpty()) {
            Student exist = findStudentById(id);
            if (exist == null) {
                students.add(new Student(id, name, score));
            }
        }
    }

    public Student findStudentById(String id) {
        for (Student student : students) {
            if (student.isId(id)) {
                return student;
            }
        }
        return null;
    }

    public void giveScoreToId(String id, double score) {
        Student exist = findStudentById(id);
        if (exist != null) {
            exist.addScore(score);
        }
    }

    public Student findStudentByObject(Student student) {
        if (students.contains(student)) {
            return student;
        }
        return null;
    }

    public String viewGradeOfId(String id) {
        Student exist = findStudentById(id);
        if (exist != null) {
            return exist.grade();
        }
        return null;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() { // บอกว่า คือ class studentList
        return "StudentList{" +
                "students=" + students +
                '}';
    }

    public void sort() {
        Collections.sort(students);
    }

    public void sort(Comparator<Student> cmp) { // ต้องระบุ gennaric type
        Collections.sort(students, cmp); // รับ interface
    }

    public Student max(Comparator<Student> cmp){
        if (students.size() == 0){
            throw new IllegalStateException("No Students in List");
        }
        Student maxStudent = students.get(0);
        for (Student s: students){
            if (cmp.compare(s, maxStudent) > 0){
                maxStudent = s;
            }
        }
        return maxStudent;
    }

    public Student max() {
        if (students.size() == 0) {
            throw new IllegalStateException("No Students in List");
        }
        Student maxStudent = students.get(0);
        for (Student s : students) {
            if (s.compareTo(maxStudent) > 0) {
                maxStudent = s;
            }
        }
        return maxStudent;
    }
    public StudentList() {
        students = new ArrayList<>();
    }

}