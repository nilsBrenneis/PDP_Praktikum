package aufgabe4.decorator;

import aufgabe4.Konsolenausgabe;

/**
 * Created by nils on 20.01.17.
 */
public class LetterCounter {

    private Konsolenausgabe k;
    private String str;
    private int count = 0;

    public LetterCounter(String s, Konsolenausgabe k) {
        this.str = s;
        this.k = k;
    }

    public void countLetters(String s) {
        count += s.length();
    }
}
