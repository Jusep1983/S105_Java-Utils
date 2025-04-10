package level1.exercise2;

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

    public void buildDirectoryListing(File directory) {
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
                    System.out.println(type + " " + file + " " + lastModification);
                }
            }
        }
    }

}
