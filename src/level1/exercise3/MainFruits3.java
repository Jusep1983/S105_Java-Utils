package level1.exercise3;

import java.io.File;
import java.util.ArrayList;

public class MainFruits3 {

    public static void main(String[] args) {

        Fruits fr = new Fruits();
        ArrayList<String> filesList = new ArrayList<>();
        filesList = fr.listDirectory(new File(fr.getFilePath()));
        fr.writeNewList(filesList);

    }

}
