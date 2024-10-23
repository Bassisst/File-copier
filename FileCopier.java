package wins;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileCopier {
    public static void main(String[] args) {
       
        String sourceDir = "D:\\jpg files";       
        String targetDir = "D:\\jpg files";     
        String fileExtension = ".jpg";

        copyFilesWithExtension(sourceDir, targetDir, fileExtension);
    }

    public static void copyFilesWithExtension(String sourceDir, String targetDir, String fileExtension) {
        File sourceFolder = new File(sourceDir);
        File[] files = sourceFolder.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                try {
                    Path sourcePath = file.toPath();
                    Path targetPath = new File(targetDir, file.getName()).toPath();
                    Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Copied: " + file.getName());
                } catch (IOException e) {
                    System.out.println("Failed to copy: " + file.getName());
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No files found with the extension " + fileExtension);
        }
    }
}
