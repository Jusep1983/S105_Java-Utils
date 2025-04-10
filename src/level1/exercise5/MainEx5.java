package level1.exercise5;

import java.nio.file.Path;

public class MainEx5 {

    public static void main(String[] args) {

        String filePath = Path.of("src", "level1", "exercise4", "Manuel.ser").toString();

        Person manuel = new Person("Manuel Butrull", 55);

        SerializePerson.serializeToManuel(filePath, manuel);

        Person segundoManuel = (SerializePerson.deserializeToManuel(filePath));

        SerializePerson.showMessage(manuel, segundoManuel, filePath);

    }

}
