package level1.exercise3;

import java.io.File;
import java.nio.file.Path;

public class MainEx3 {

    public static void main(String[] args) {

        String directoryName = Path.of("src", "level1", "exercise3").toString();

        DirectoryUtils directoryUtils = new DirectoryUtils();

        directoryUtils.setDirectoryList(directoryUtils.buildDirectoryListing(new File(directoryName)));

        directoryUtils.writeNewListInFile(directoryUtils.getDirectoryList(), directoryName);

    }

}
