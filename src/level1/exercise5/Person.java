package level1.exercise5;

import java.io.*;

public class Person implements Serializable {
    private String name;
    private int age;
    @Serial
    private static final long serialVersionUID = 1L;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{name: " + name + ", age: " + age + ", hash code: " + this.hashCode() + "}";
    }
}
