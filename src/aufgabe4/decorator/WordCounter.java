package aufgabe4.decorator;

import aufgabe4.Ausgabe;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nils on 20.01.17.
 */
public class WordCounter extends Dekorator {
    private final String compare;
    private int wordCount = 0;

    public WordCounter(String wordToCount, Ausgabe k) {
        super(k);
        this.compare = wordToCount;
    }

    public int getWordCount() { return wordCount; }

    private void countOccurences(String s) {
        Pattern p = Pattern.compile(compare);
        Matcher m = p.matcher(s);
        while (m.find()) {
            wordCount++;
        }
    }

    @Override
    public void print(String s) {
        countOccurences(s);
        super.print(s);
    }
}
