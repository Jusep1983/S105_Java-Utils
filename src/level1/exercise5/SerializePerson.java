package level1.exercise5;

import java.io.*;

public class SerializePerson {

    public static void serializeToManuel(String filePath, Person person) {

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(person);
            System.out.println("Hemos serializado al pobre " + person.getName());
            if (!new File(filePath).exists()) {
                checkFilePath(new File(filePath));
                new File(filePath).createNewFile();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error, archivo no encontrado " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error, " + e.getMessage());
        }
    }

    public static Person deserializeToManuel(String filePath) {
        Person deserializePerson = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            deserializePerson = (Person) objectInputStream.readObject();
            System.out.println("Hemos deserializado, trayendo de vuelta a  " + deserializePerson.getName()
                               + " y depositandolo en un nuevo contenedor de Objeto tipo Person.");
            checkPath(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("Error, ruta " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error, " + e.getMessage());
        }
        return deserializePerson;
    }

    private static void checkPath(String filePath) throws FileNotFoundException {
        if (!new File(filePath).exists()) {
            throw new FileNotFoundException("archivo no encontrado");
        }
    }

    private static void checkFilePath(File filePath) throws FileNotFoundException {
        if (!filePath.exists()) {
            throw new FileNotFoundException("archivo no encontrado");
        }
    }

    public static void showMessage(Person instantiatedPerson, Person deserializedPerson, String filePath) {
        if (new File(filePath).exists()) {
            System.out.println("Ahora hay dos Manuel Butrull exactamente iguales: ");
            System.out.println(instantiatedPerson);
            System.out.println(deserializedPerson);
        } else {
            System.out.println("El programa no ha podido ejecutarse");
        }
    }

}
