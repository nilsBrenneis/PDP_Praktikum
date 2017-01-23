package aufgabe4.decorator;

import aufgabe4.Ausgabe;

/**
 * Created by nils on 23.01.17.
 */
public class Dekorator implements Ausgabe {

    private final Ausgabe k;

    Dekorator(Ausgabe k) {
        this.k = k;
    }
    @Override
    public void print(String s) {
        k.print(s);
    }
}
