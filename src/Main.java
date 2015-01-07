import java.io.UnsupportedEncodingException;

/**
 * Created by paulvoropaiev on 1/3/15.
 */



public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {

//        boolean result;
//
//        UkrNetParsing ukrNetParsing = new UkrNetParsing(3);
//        ukrNetParsing.parse(3);
//        result = ukrNetParsing.parse(3);
//        if (result) {
//            ukrNetParsing.printNewItems();
//        }

//        ObozrevatelParsing obozrevatelParsing = new ObozrevatelParsing();
//        result = obozrevatelParsing.parse(20);
//        if (result) {
//            obozrevatelParsing.printNewItems();
//        }

        new Thread(new UpdateService()).start();
//
//        MailService mailService = new MailService();
//        mailService.sendEmail("Hi there!");


    }
}
