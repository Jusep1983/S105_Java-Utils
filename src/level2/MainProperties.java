package level2;

import java.io.File;
import java.util.ArrayList;

public class MainProperties {

    public static void main(String[] args) {

        DirectoryUtils directoryUtils = new DirectoryUtils();

        ArrayList<String> filesList = new ArrayList<>();
        try {
            filesList = directoryUtils.buildDirectoryListing(new File(directoryUtils.getInputDirectory()));
        } catch (RuntimeException e) {
            System.err.println("Error, propiedad inputDirectory no encontrada. ");
        }
        directoryUtils.writeListingToFile(filesList);
    }

}
