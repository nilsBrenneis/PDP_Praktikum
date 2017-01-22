package aufgabe4;

import aufgabe4.decorator.PostfixAdder;
import aufgabe4.decorator.LetterCounter;
import aufgabe4.decorator.UpperCase;
import aufgabe4.decorator.WordCounter;

/**
 * Created by nils on 20.01.17.
 */
public class AusgabeAggregator {

    private static final StringBuffer sb = new StringBuffer();
    private static final String marker =  "******";

    private static void append(String s) { sb.append(s); }

    private static String myToString() { return sb.toString(); }

    public static void main(String[] args) {
        AusgabeAggregator ausgA = new AusgabeAggregator();
        Konsolenausgabe konsA = new Konsolenausgabe();

        append("Was ist das für 1 ");
        append("life?");

        System.out.println(System.lineSeparator() +  marker + "LetterCounter" + marker);
        LetterCounter lc = new LetterCounter(konsA);
        lc.print(myToString());
        System.out.println(lc.getCount());

        System.out.println(System.lineSeparator() + marker + "UpperCase" + marker);
        UpperCase uc = new UpperCase(konsA);
        uc.print(myToString());

        System.out.println(System.lineSeparator() + marker + "WordCounter" + marker);
        WordCounter wc = new WordCounter("life", konsA);
        wc.print(myToString());
        System.out.println(wc.getWordCount());

        System.out.println(System.lineSeparator() + marker + "PostfixAdder" + marker);
        PostfixAdder cf = new PostfixAdder("chen", konsA);
        cf.print(myToString());
    }

}
