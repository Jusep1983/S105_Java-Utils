package level1.exercise3;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Fruits {
    private ArrayList<String> fruits;
    private String filePath;

    public Fruits() {
        this.fruits = new ArrayList<>();
        this.filePath = "src" + File.separator + "level1" + File.separator + "exercise3";
    }

    public String getFilePath() {
        return filePath;
    }

}
