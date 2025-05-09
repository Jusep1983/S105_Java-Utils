package level3;

import java.security.InvalidParameterException;
import java.security.NoSuchAlgorithmException;

public class MainEncryptor {

    public static void main(String[] args) {

        String inputFile = FileEncryptor.loadProperties("inputFile");
        String encryptedFile = FileEncryptor.loadProperties("encryptedFile");
        String decryptedFile = FileEncryptor.loadProperties("decryptedFile");

        FileEncryptor fileEncryptor;

        try {
            fileEncryptor = new FileEncryptor();
            fileEncryptor.encryptFile(inputFile, encryptedFile);
            fileEncryptor.decryptFile(encryptedFile, decryptedFile);
        } catch (NoSuchAlgorithmException | InvalidParameterException e) {
            System.err.println("Error, " + e.getMessage());
        }
    }

}
