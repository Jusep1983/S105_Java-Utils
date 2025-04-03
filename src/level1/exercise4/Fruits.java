package level1.exercise4;

import java.io.*;
import java.util.ArrayList;

public class Fruits {
    private ArrayList<String> fruits;
    private String filePath;

    public Fruits() {
        this.fruits = new ArrayList<>();
        this.filePath = "src" + File.separator + "level1" + File.separator + "exercise4";
    }

    public void showContentOfFileTxt(String fileName) {
        String fullPath = this.filePath + File.separator + fileName;
        ArrayList<String> contentOfFileTxt = new ArrayList<>();
        File file = new File(fullPath);

        System.out.println("Contenido del archivo " + fullPath + ": ");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    contentOfFileTxt.add(line);
                }
            }
            for (String content : contentOfFileTxt) {
                System.out.println("\t" + content);
            }
            if (contentOfFileTxt.isEmpty()) {
                System.out.println("\t----esta vacío----");
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("Error, archivo no encontrado" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error, " + e.getMessage());
        }
    }

}
