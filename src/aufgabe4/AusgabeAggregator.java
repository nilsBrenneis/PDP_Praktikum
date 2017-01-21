package aufgabe4;

/**
 * Created by nils on 20.01.17.
 */
public class AusgabeAggregator {

    private static StringBuffer sb = new StringBuffer();

    public static void append(String s) { sb.append(s); }

    public static String myToString() { return sb.toString(); }
}
