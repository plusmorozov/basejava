package basejava.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class MainFile {
    public static void main(String[] args) {
        String filePath = ".\\.gitignore";
        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }
        File dir = new File("C:\\Java\\basejava\\src\\basejava\\webapp");
        System.out.println(dir.isDirectory());
        for (String name : Objects.requireNonNull(dir.list())) {
            System.out.println(name);
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        printDirectory(new File("C:\\Java\\basejava\\src\\basejava"));
     }

    public static void printDirectory(File dir) {
        File[] list = dir.listFiles();
        if (list == null) return;
        for (File file : list) {
            if (file.isDirectory()) {
                System.out.println("Dir: " + file.getName());
                printDirectory(file);
            } else {
                System.out.println("File: " + file.getName());
            }
        }
    }

}
