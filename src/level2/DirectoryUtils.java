package level2;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class DirectoryUtils {
    private String inputDirectory;
    private String outputFile;

    public DirectoryUtils() {
        loadProperties();
    }

    public String getInputDirectory() {
        return inputDirectory;
    }

    public void loadProperties() {
        try {
            FileInputStream fis = new FileInputStream("src" + File.separator + "level2" + File.separator + "config.properties");
            Properties props = new Properties();
            props.load(fis);
            this.inputDirectory = props.getProperty("inputDirectory");
            this.outputFile = props.getProperty("outputFile");
            checkProperties();
        } catch (IllegalArgumentException | IOException | MissingOutputFileException e) {
            System.err.println("Error, " + e.getMessage());
        }
    }

    private void checkProperties() {
        if (this.outputFile == null) {
            throw new MissingOutputFileException("en el archivo de configuración falta archivo de destino");
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

    public void writeListingToFile(List<String> filesList) {
        String fullPath = this.inputDirectory + File.separator + this.outputFile;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fullPath))) {
            for (String file : filesList) {
                writer.write(file);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error, " + e.getMessage());
        }
    }

}
