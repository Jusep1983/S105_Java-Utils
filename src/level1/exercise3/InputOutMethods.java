package level1.exercise3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class InputOutMethods {

    public ArrayList<String> listDirectory(File filePath) {
        ArrayList<String> filesList = new ArrayList<>();
        if (filePath.isDirectory()) {
            File[] files = filePath.listFiles();
            if (files == null) {
                System.out.println("El directorio no existe");
            } else if (files.length == 0) {
                System.out.println("El directorio esta vacío");
            } else {
                Arrays.sort(files);
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                for (File file : files) {
                    String type = file.isDirectory() ? "DIR" : "FIL";
                    String lastModification = sdf.format(new Date(file.lastModified()));
                    filesList.add(type + " " + file + " " + lastModification);
                }
            }
        }
        return filesList;
    }

    public void writeNewList(ArrayList<String> filesList, String filePath) {
        String fullPath = filePath + File.separator + "directoryList.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fullPath))) {
            for (String file: filesList) {
                writer.write(file);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error, " + e.getMessage());
        }
    }
}
