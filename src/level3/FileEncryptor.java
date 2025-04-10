package level3;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.security.*;
import java.util.Properties;

public class FileEncryptor {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    private final SecretKey SECRET_KEY;
    private final IvParameterSpec IV;

    public FileEncryptor() throws NoSuchAlgorithmException {
        this.SECRET_KEY = generateKey();
        this.IV = generateIV();
    }

    public static String loadProperties(String loadProperty) {
        String nameProperty = "";
        try {
            FileInputStream fis = new FileInputStream(
                    "src" + File.separator + "level3" + File.separator + "config.properties"
            );
            Properties props = new Properties();
            props.load(fis);
            nameProperty = props.getProperty(loadProperty);
            checkProperties(nameProperty);
        } catch (IOException e) {
            System.err.println("Error " + e.getMessage());
        }
        return nameProperty;
    }

    public static void checkProperties(String nameProperty) throws FileNotFoundException {
        if (nameProperty == null) {
            throw new FileNotFoundException("en el archivo de configuración, propiedades faltantes");
        }
    }

    // Generate a 128-bit AES key
    private SecretKey generateKey() throws NoSuchAlgorithmException ,InvalidParameterException {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            keyGenerator.init(128);
            return keyGenerator.generateKey();
    }

    // Generate a random 16-byte IV
    private IvParameterSpec generateIV() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public void encryptFile(String inputFile, String outputFile) {
        Cipher cipher;
        try {
            cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, this.SECRET_KEY, this.IV);

            try (FileInputStream fis = new FileInputStream(inputFile);// Leer el archivo como bytes
                 FileOutputStream fos = new FileOutputStream(outputFile);// Escribir archivo encriptado
                 CipherOutputStream cos = new CipherOutputStream(fos, cipher)) {// Leer el archivo como bytes

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    cos.write(buffer, 0, bytesRead);
                }
            }
            System.out.println("Archivo encriptado correctamente: " + outputFile);
        } catch (IOException | GeneralSecurityException | NullPointerException e) {
            System.err.println("Error al encriptar el archivo " + e.getMessage());
        }
    }

    public void decryptFile(String inputFile, String outputFile) {
        try {
            // Obtener el Cipher para AES con CBC y PKCS5Padding
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, this.SECRET_KEY, this.IV);

            try (FileInputStream fis = new FileInputStream(inputFile);  // Leer archivo encriptado como bytes
                 FileOutputStream fos = new FileOutputStream(outputFile);  // Escribir archivo desencriptado
                 CipherOutputStream cos = new CipherOutputStream(fos, cipher)) {  // Escribir desencriptado

                byte[] buffer = new byte[1024];  // Buffer para lectura/escritura de bytes
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    cos.write(buffer, 0, bytesRead);  // Escribir los bytes desencriptados
                }
            }
            System.out.println("Archivo desencriptado correctamente: " + outputFile);
        } catch (IOException | GeneralSecurityException | NullPointerException e) {
            System.err.println("Error al desencriptar el archivo " + e.getMessage());
        }
    }

}
