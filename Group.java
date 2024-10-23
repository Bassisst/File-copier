package wins;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String groupName;
    private List<Student> students;


    public Group(String groupName) {
        this.groupName = groupName;
        this.students = new ArrayList<>();
    }


    public void addStudent(Student student) {
        students.add(student);
    }


    public void removeStudentById(int id) {
        students.removeIf(student -> student.getId() == id);
    }


    public List<Student> getStudents() {
        return students;
    }


    public String getGroupName() {
        return groupName;
    }


    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Group: " + groupName + "\n");
        for (Student student : students) {
            sb.append(student.toString()).append("\n");
        }
        return sb.toString();
    }
}
