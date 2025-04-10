package level1.exercise1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class DirectoryUtils {
    private ArrayList<String> directoryList;

    public DirectoryUtils() {
        this.directoryList = new ArrayList<>();

    }

    public ArrayList<String> getDirectoryUtils() {
        return directoryList;
    }

    public void readAndSortFileLines(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    this.directoryList.add(line);
                }
            }
            Collections.sort(this.directoryList);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error, " + e.getMessage());
        }
    }

}
