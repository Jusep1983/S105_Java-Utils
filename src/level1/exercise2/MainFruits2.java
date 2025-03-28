package level1.exercise2;

import java.io.File;

public class MainFruits2 {

    public static void main(String[] args) {

        Fruits fr = new Fruits();

        fr.listDirectory(new File(fr.getFilePath()));

    }

}
