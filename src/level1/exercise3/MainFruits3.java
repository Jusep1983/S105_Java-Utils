package level1.exercise3;

import java.io.File;
import java.util.ArrayList;

public class MainFruits3 {

    public static void main(String[] args) {
        InputOutMethods inputOutput = new InputOutMethods();
        Fruits fruits = new Fruits();
        ArrayList<String> filesList = new ArrayList<>();
        filesList = inputOutput.listDirectory(new File(fruits.getFilePath()));
        inputOutput.writeNewList(filesList, fruits.getFilePath());

    }

}
