package level3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

public class MainEncryptor {

    public static void main(String[] args) {

//        String inputFile= "src" + File.separator + "level3" + File.separator + "fruitsLvl3.txt";
//        String encryptedFile= "src" + File.separator + "level3" + File.separator + "macedoniaSecreta_encrypted.txt";
//        String decryptedFile = "src" + File.separator + "level3" + File.separator + "macedoniaPublica_decrypted.txt";


        String inputFile = loadProperties("inputFile");
        String encryptedFile = loadProperties("encryptedFile");
        String decryptedFile = loadProperties("decryptedFile");

        FileEncryptor fileEncryptor = null;

        try {
            fileEncryptor = new FileEncryptor();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        fileEncryptor.encryptFile(inputFile, encryptedFile);
        fileEncryptor.decryptFile(encryptedFile, decryptedFile);
    }

    public static String loadProperties(String loadProperty) {
        String nameProperty = "";
        try {
            FileInputStream fis = new FileInputStream("src" + File.separator + "level3" + File.separator + "config.properties");
            Properties props = new Properties();
            props.load(fis);
            nameProperty = props.getProperty(loadProperty);

            if (nameProperty == null) {
                throw new FileNotFoundException("en el archivo de configuración: Propiedades faltantes");
            }
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
        return nameProperty;
    }
}
