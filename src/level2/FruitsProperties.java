package level2;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

public class FruitsProperties {
    private ArrayList<String> fruits;
    private String filePath;
    private String fileName;

    public FruitsProperties() {
        this.fruits = new ArrayList<>();
        loadProperties();
    }

    public String getFilePath() {
        return filePath;
    }

    public void loadProperties() throws RuntimeException{
        try {
            FileInputStream fis = new FileInputStream("src" + File.separator + "level2" + File.separator + "config.properties");
            Properties props = new Properties();
            props.load(fis);
            this.filePath = props.getProperty("inputDirectory");
            this.fileName = props.getProperty("outputFile");
            checkProperties();
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    private void checkProperties() throws FileNotFoundException {
        if (this.filePath == null || this.fileName == null) {
            throw new FileNotFoundException("en el archivo de configuración: Propiedades faltantes");
        }
    }

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

    public void writeNewList(ArrayList<String> filesList) {
        String fullPath = this.filePath + File.separator + "directoryList.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fullPath))) {
            for (String file : filesList) {
                writer.write(file);
                writer.newLine();
            }
        } catch (IOException | RuntimeException e) {
            System.out.println("Error, " + e.getMessage());
        }
    }

}
