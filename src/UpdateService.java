import java.util.HashSet;
import java.util.Set;

/**
 * Created by paulvoropaiev on 1/5/15.
 */
public class UpdateService implements Runnable {

    Set<String> newsSetSource = new HashSet<>();
    Set<String> newsSetTemp = new HashSet<>();
    Set<String> updateSet = new HashSet<>();
    String stringToSend = "";
    boolean isChanged = false;
    int newsQuantity = 3;

    @Override
    public void run() {

        newsSetSource = new UkrNetParsing(/*newsQuantity*/).parse(newsQuantity);;
        UkrNetParsing parsingTemp = new UkrNetParsing(/*newsQuantity*/);
        MailService mailService = new MailService();

        while (true) {

            newsSetTemp = parsingTemp.parse(newsQuantity);

            System.out.println("***Source:");
            for (String s : newsSetSource) {
                System.out.println(s);
            }

            updateSet.clear();
            System.out.println("***Temp:");
            for (String v : newsSetTemp) {
                System.out.println(v);
                if (!newsSetSource.contains(v)) {
                    System.out.println("New item! " + v);
                    updateSet.add(v);
                    isChanged = true;
                    System.out.println("=======\nItems to update:");
                }
            }

            for (String s : updateSet) {
                System.out.println(s);
                stringToSend += s + "\n";
            }

            System.out.println("-----------------------");

            if (isChanged) {
                mailService.sendEmail(stringToSend);
                stringToSend = "";
            }
            
            updateSet.clear();
            newsSetSource.clear();
            newsSetSource.addAll(newsSetTemp);
            isChanged = false;

            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
