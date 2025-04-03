package level1.exercise5;

import java.io.File;

public class MainManuelSerial {

    public static void main(String[] args) {

        String filePath = "src" + File.separator + "level1" + File.separator + "exercise4" + File.separator + "Manuel.ser";

        Person manuel = new Person("Manuel Butrull", 55);

        SerializeObjects.serializeToManuel(filePath, manuel);

        Person segundoManuel = (SerializeObjects.deserializeToManuel(filePath));

        SerializeObjects.showMessage(manuel, segundoManuel, filePath);

    }

}
