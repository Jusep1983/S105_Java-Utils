package level1.exercise3;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class DirectoryUtils {
    private ArrayList<String> directoryList;

    public DirectoryUtils() {
        this.directoryList = new ArrayList<>();
    }

    public ArrayList<String> getDirectoryList() {
        return this.directoryList;
    }

    public void setDirectoryList(ArrayList<String> directoryList) {
        this.directoryList = directoryList;
    }

    public ArrayList<String> buildDirectoryListing(File directory) {
        ArrayList<String> filesList = new ArrayList<>();
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
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

    public void writeNewListInFile(ArrayList<String> filesList, String directoryName) {
        String fullPath = directoryName + File.separator + "directoryList.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fullPath))) {
            for (String file : filesList) {
                writer.write(file);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error, " + e.getMessage());
        }
    }

}
