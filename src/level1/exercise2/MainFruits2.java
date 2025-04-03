package level1.exercise2;

import java.io.File;

public class MainFruits2 {

    public static void main(String[] args) {

        ListDirectory listDirectory = new ListDirectory();
        Fruits fruits = new Fruits();
        listDirectory.listDirectory(new File(fruits.getFilePath()));

    }

}
