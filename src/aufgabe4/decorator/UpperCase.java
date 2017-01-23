package aufgabe4.decorator;

import aufgabe4.Ausgabe;

/**
 * Created by nils on 20.01.17.
 */
public class UpperCase extends Dekorator {
    public UpperCase(Ausgabe k) { super(k); }

    private String toUpperCase(String s) { return s.toUpperCase(); }

    @Override
    public void print(String s) { super.print(toUpperCase(s)); }
}
