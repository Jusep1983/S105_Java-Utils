package level1.exercise1;

import java.io.*;
import java.util.ArrayList;

public class Fruits {
    private ArrayList<String> fruits;
    private String filePath;

    public Fruits() {
        this.fruits = new ArrayList<String>();
        this.filePath = "src" + File.separator + "level1" + File.separator + "exercise1" + File.separator + "fruitsLvl2.txt";
    }

    public ArrayList<String> getFruits() {
        return fruits;
    }

    public void sortAlphabetizeFruits() {
        int numberLine = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    this.fruits.add(line);
                }
                numberLine++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " /*+ this.filePath + " "*/ + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
