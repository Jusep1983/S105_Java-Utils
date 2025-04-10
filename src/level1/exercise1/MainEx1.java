package level1.exercise1;

import java.nio.file.Path;

public class MainEx1 {
    public static void main(String[] args) {
        String filePath = Path.of("src", "level1", "exercise1", "fruits.txt").toString();

        DirectoryUtils fr = new DirectoryUtils();

        fr.readAndSortFileLines(filePath);

        for (int i = 0; i < fr.getDirectoryUtils().size(); i++) {
            System.out.println(fr.getDirectoryUtils().get(i));
        }
    }
}
