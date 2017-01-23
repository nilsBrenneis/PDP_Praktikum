package aufgabe4.decorator;

import aufgabe4.Ausgabe;

/**
 * Created by nils on 20.01.17.
 */
public class LetterCounter extends Dekorator {

    private int count = 0;

    public LetterCounter(Ausgabe k) {
        super(k);
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
        super.print(s);
    }
}
