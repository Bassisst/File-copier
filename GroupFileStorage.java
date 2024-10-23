package wins;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.stream.Collectors;

public class GroupFileStorage {


    public void saveGroupToCSV(Group gr) throws IOException {
        String fileName = gr.getGroupName() + ".csv";  // Название файла соответствует названию группы
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Student student : gr.getStudents()) {
                String studentData = String.join(",", 
                    student.getName(),
                    student.getSurname(),
                    String.valueOf(student.getAge()),
                    student.getGender(),
                    String.valueOf(student.getId())
                );
                writer.write(studentData);
                writer.newLine();
            }
        }
    }


    public Group loadGroupFromCSV(File file) throws IOException {
        Group group = new Group(file.getName().replace(".csv", ""));
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] studentData = line.split(",");
                Student student = new Student(
                    studentData[0],          
                    studentData[1],         
                    Integer.parseInt(studentData[2]),  
                    studentData[3],          
                    Integer.parseInt(studentData[4])   
                );
                group.addStudent(student);
            }
        }
        return group;
    }


    public File findFileByGroupName(String groupName, File workFolder) {
        File[] files = workFolder.listFiles((dir, name) -> name.equals(groupName + ".csv"));
        if (files != null && files.length > 0) {
            return files[0]; 
        }
        return null; 
    }
}

