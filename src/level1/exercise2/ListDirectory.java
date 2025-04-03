package level1.exercise2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ListDirectory {
    public void listDirectory(File filePath){
        if(filePath.isDirectory()){
            File[] files = filePath.listFiles();
            if(files == null){
                System.out.println("El directorio no existe");
            }else if (files.length == 0) {
                System.out.println("El directorio esta vacío");
            }else{
                Arrays.sort(files);
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                for(File file : files){
                    String type = file.isDirectory() ? "DIR" : "FIL";
                    String lastModification = sdf.format(new Date(file.lastModified()));
                    System.out.println(type + " " + file + " " + lastModification);
                }
            }
        }
    }
}
