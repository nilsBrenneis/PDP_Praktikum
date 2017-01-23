package aufgabe4.decorator;

import aufgabe4.Ausgabe;

/**
 * Created by nils on 22.01.17.
 */
public class PostfixAdder extends Dekorator {
    private final String stringToAdd;

    public PostfixAdder(String postfix, Ausgabe k) {
        super(k);
        this.stringToAdd = postfix + " ";
    }

    private String addPostfix(String s) {
        String[] sArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String aSArr : sArr) {
            sb.append(aSArr).append(stringToAdd);
        }
        return sb.toString();
    }

    @Override
    public void print(String s) { super.print(addPostfix(s)); }
}
