package aufgabe4;

/**
 * Created by nils on 20.01.17.
 */
public class AusgabeAggregator implements Ausgabe {

    private final StringBuffer sb = new StringBuffer();

    private String myToString() { return sb.toString(); }

    @Override
    public void print(String s) { sb.append(s); System.out.println(s); }
}
