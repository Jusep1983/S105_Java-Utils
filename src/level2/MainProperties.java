package level2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MainProperties {

    public static void main(String[] args) throws FileNotFoundException, RuntimeException {

        FruitsProperties fruitslvl2 = new FruitsProperties();

        ArrayList<String> filesList = new ArrayList<>();
        try {
            filesList = fruitslvl2.listDirectory(new File(fruitslvl2.getFilePath()));
        } catch (RuntimeException e) {
            System.out.println("Error, " + e.getMessage());
        }
        fruitslvl2.writeNewList(filesList);

    }

}
