package aufgabe4.decorator;

import aufgabe4.KonsAuInterface;
import aufgabe4.Konsolenausgabe;

/**
 * Created by nils on 20.01.17.
 */
public class LetterCounter implements KonsAuInterface {

    private final Konsolenausgabe k;
    private int count = 0;

    public LetterCounter(Konsolenausgabe k) {
        this.k = k;
    }

    private void countLetters(String s) {
        count += s.length();
    }

    public int getCount() {
        return count;
    }

    @Override
    public void print(String s) {
        countLetters(s);
        k.print(s);
    }
}
