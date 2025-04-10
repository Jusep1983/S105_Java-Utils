package level1.exercise2;

import java.io.File;
import java.nio.file.Path;

public class MainEx2 {

    public static void main(String[] args) {

        String directory = Path.of("src", "level1", "exercise2").toString();

        DirectoryUtils directoryUtils = new DirectoryUtils();

        directoryUtils.buildDirectoryListing(new File(directory));

    }

}
