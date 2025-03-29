package level2;

import java.io.File;
import java.util.ArrayList;

public class MainProperties {

    public static void main(String[] args) {

        FruitsProperties fruitslvl2 = new FruitsProperties();

        ArrayList<String> filesList = new ArrayList<>();

        filesList = fruitslvl2.listDirectory(new File(fruitslvl2.getFilePath()));

        fruitslvl2.writeNewList(filesList);

    }

}
