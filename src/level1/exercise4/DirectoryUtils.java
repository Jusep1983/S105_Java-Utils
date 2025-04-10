package level1.exercise4;

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


    public void showContentOfFileTxt(String fullPath) {
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

    public void writeNewList(ArrayList<String> filesList, String directoryName) {
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
