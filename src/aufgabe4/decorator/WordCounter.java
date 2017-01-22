package aufgabe4.decorator;

import aufgabe4.KonsAuInterface;
import aufgabe4.Konsolenausgabe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nils on 20.01.17.
 */
public class WordCounter implements KonsAuInterface {

    private final Konsolenausgabe k;
    private final String compare;
    private int wordCount = 0;

    public WordCounter(String str, Konsolenausgabe k) {
        this.compare = str;
        this.k = k;
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
        k.print(s);
    }
}
