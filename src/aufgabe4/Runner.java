package aufgabe4;

import aufgabe4.decorator.LetterCounter;
import aufgabe4.decorator.PostfixAdder;
import aufgabe4.decorator.UpperCase;
import aufgabe4.decorator.WordCounter;

/**
 * Created by nils on 23.01.17.
 */
public class Runner {
    private static final String marker =  "******";

    public static void main(String[] args) {
        
        System.out.println(System.lineSeparator() +  marker + "LetterCounter" + marker);
        LetterCounter lcA = new LetterCounter(new AusgabeAggregator());
        LetterCounter lcK = new LetterCounter(new Konsolenausgabe());
        lcA.print("Hallo");
        lcK.print("Hallo");
        System.out.println(lcA.getCount());
        System.out.println(lcK.getCount());

        System.out.println(System.lineSeparator() + marker + "UpperCase" + marker);
        UpperCase ucA = new UpperCase(new AusgabeAggregator());
        UpperCase ucK = new UpperCase(new Konsolenausgabe());
        ucA.print("Hallo");
        ucK.print("Hallo");

        System.out.println(System.lineSeparator() + marker + "WordCounter" + marker);
        WordCounter wcA = new WordCounter("Hallo", new AusgabeAggregator());
        WordCounter wcK = new WordCounter("Hallo", new Konsolenausgabe());
        wcA.print("Hallo Welt Hallo hallo");
        wcK.print("Hallo Welt Hallo hallo");
        System.out.println(wcA.getWordCount());
        System.out.println(wcK.getWordCount());

        System.out.println(System.lineSeparator() + marker + "PostfixAdder" + marker);
        PostfixAdder cfA = new PostfixAdder("chen", new AusgabeAggregator());
        PostfixAdder cfK = new PostfixAdder("chen", new Konsolenausgabe());
        cfA.print("Hallö Welt");
        cfK.print("Hallö Welt");
    }
}
