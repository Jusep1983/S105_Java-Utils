package level3;


import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class FileEncryptor {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    private SecretKey secretKey;
    private IvParameterSpec iv;

    public FileEncryptor() throws NoSuchAlgorithmException {
        this.secretKey = generateKey();
        this.iv = generateIV();
    }

    // Generate a 128-bit AES key
    private SecretKey generateKey() throws NoSuchAlgorithmException {
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
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, this.secretKey, this.iv);

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
        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException | NoSuchPaddingException |
                 InvalidKeyException | IOException e) {
            e.printStackTrace();
        }
    }

    public void decryptFile(String inputFile, String outputFile) {
        try {
            // Obtener el Cipher para AES con CBC y PKCS5Padding
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, this.secretKey, this.iv);

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
