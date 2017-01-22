package aufgabe4.decorator;

import aufgabe4.KonsAuInterface;
import aufgabe4.Konsolenausgabe;

/**
 * Created by nils on 20.01.17.
 */
public class UpperCase implements KonsAuInterface {

    private final Konsolenausgabe k;

    public UpperCase(Konsolenausgabe k) { this.k = k; }

    private String toUpperCase(String s) { return s.toUpperCase(); }

    @Override
    public void print(String s) { k.print(toUpperCase(s)); }
}
