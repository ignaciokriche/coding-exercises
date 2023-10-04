package ar.com.kriche.recursion;

/**
 *  * @author Kriche 2020
 */
public class Reverser {

    public static void main(String args[]) {
        String text = "ignacio krichevsky";
        System.out.println("original text: " + text);
        text =  revert(text);
        System.out.println("reversed text: " + text);
        System.out.println("reversed back: " + revert(text));
    }

    private static String revert(String text) {
        if (text.isEmpty()) {
            return text;
        }
        return text.substring(text.length() - 1) + revert(text.substring(0, text.length() - 1));
    }
}
