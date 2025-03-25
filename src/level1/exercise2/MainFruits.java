package level1.exercise2;

import java.util.Collections;

public class MainFruits {
    public static void main(String[] args) {
        Fruits fr = new Fruits();
        fr.sortAlphabetizeFruits();
        Collections.sort(fr.getFruits());
        for (int i = 0; i < fr.getFruits().size(); i++) {
            System.out.println(fr.getFruits().get(i));
        }
    }

    public void listingDirectory(){

    }
}
