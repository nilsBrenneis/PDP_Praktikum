package aufgabe4.decorator;

import aufgabe4.Konsolenausgabe;

/**
 * Created by nils on 20.01.17.
 */
public class WordCounter {

    private Konsolenausgabe k;
    private String compare;
    private int wordCount = 0;

    public WordCounter(String str, Konsolenausgabe k) {
        this.compare = str;
        this.k = k;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void countOccurences(String s) {
        String str = k.toString();
        int count = str.length() - str.replace(compare, "").length();
    }
}
