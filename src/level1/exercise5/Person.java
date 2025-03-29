package level1.exercise5;

import java.io.*;

public class Person implements Serializable {
    private String name;
    private int age;
    private static final long serialVersionUID = 1L;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void serializeToManuel(String filePath, Person person) {

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(person);
            System.out.println("Hemos serializado al pobre " + person.getName());
            if (!new File(filePath).exists()) {
                new File(filePath).createNewFile();
                throw new FileNotFoundException("archivo no encontrado");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error, " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Person deserializeToManuel(String filePath) {
        Person deserializePerson = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            deserializePerson = (Person) objectInputStream.readObject();
            System.out.println("Hemos deserializado, trayendo de vuelta a  " + deserializePerson.getName()
                               + " y depositandolo en un nuevo contenedor de Objeto tipo Person.");
            if (!new File(filePath).exists()) {
                throw new FileNotFoundException("archivo no encontrado");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error, " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return deserializePerson;
    }

    public static void showMessage(Person instantiatedPerson,Person deserializedPerson,String filePath){
        if (new File(filePath).exists()) {
            System.out.println("Ahora hay dos Manuel Butrull exactamente iguales: ");
            System.out.println(instantiatedPerson);
            System.out.println(deserializedPerson);
        } else {
            System.out.println("El programa no ha podido ejecutarse");
        }
    }

    @Override
    public String toString() {
        return "Person{name: " + name + ", age: " + age + ", hash code: " + this.hashCode() + "}";
    }
}
