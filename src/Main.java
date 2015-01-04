/**
 * Created by paulvoropaiev on 1/3/15.
 */



public class Main {

    public static void main(String[] args) {

        boolean result;

        UkrNetParsing ukrNetParsing = new UkrNetParsing();
        result = ukrNetParsing.parse();
        if (result) {
            ukrNetParsing.printNewItems();
        }

    }
}
