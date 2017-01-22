package aufgabe4.decorator;

import aufgabe4.KonsAuInterface;
import aufgabe4.Konsolenausgabe;

/**
 * Created by nils on 22.01.17.
 */
public class PostfixAdder implements KonsAuInterface {
    private final Konsolenausgabe k;
    private final String stringToAdd;

    public PostfixAdder(String s, Konsolenausgabe k) {
        this.stringToAdd = s + " ";
        this.k = k;
    }

    private String blinqify (String s) {
        String[] sArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String aSArr : sArr) {
            sb.append(aSArr + stringToAdd);
        }
        return sb.toString();
    }

    @Override
    public void print(String s) { k.print(blinqify(s)); }
}
