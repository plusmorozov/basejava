package basejava.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class MainFile {
    private static StringBuilder indent = new StringBuilder("");

    public static void main(String[] args) {
        String filePath = ".\\.gitignore";
        String path = "C:\\Java\\basejava\\src\\basejava\\webapp";
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
        printDirectory(path);
    }

    public static void printDirectory(String path) {
        File[] list = new File(path).listFiles();
        for (File file : Objects.requireNonNull(list)) {
            System.out.print(indent.toString());
            if (file.isFile()) {
                System.out.println(file.getName());
            } else if (file.isDirectory()) {
                System.out.println(file.getName());
                indent.append("-");
                printDirectory(path + File.separator + file.getName());
                indent.delete(indent.length() - 1, indent.length());
            }
        }
    }
}
