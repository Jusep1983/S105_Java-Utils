package level1.exercise4;

import java.io.File;
import java.nio.file.Path;

public class MainEx4 {

    public static void main(String[] args) {

        String directoryName = Path.of("src", "level1", "exercise4").toString();

        DirectoryUtils directoryUtils = new DirectoryUtils();
        directoryUtils.setDirectoryList(directoryUtils.buildDirectoryListing(new File(directoryName)));
        directoryUtils.writeNewList(directoryUtils.getDirectoryList(), directoryName);

        directoryUtils.showContentOfFileTxt(directoryName + File.separator + "fruitsLvl2.txt");
        directoryUtils.showContentOfFileTxt(directoryName + File.separator + "directoryList.txt");
        directoryUtils.showContentOfFileTxt(directoryName + File.separator + "empty.txt");
        directoryUtils.showContentOfFileTxt(directoryName + File.separator + "archivoInventado.txt");

    }

}

