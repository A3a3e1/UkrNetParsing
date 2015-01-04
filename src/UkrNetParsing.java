import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by paulvoropaiev on 1/4/15.
 */
public class UkrNetParsing implements Parsable {

    Map<Integer, String> mainNewsTextMap = new HashMap();
    String urlToParse = "https://www.ukr.net/";

    @Override
    public boolean parse() {

        Document doc = null;
        Elements elements = null;
        try {
            doc = Jsoup.connect(urlToParse).get();
            elements = doc.select("div > h3 > a");
            for (int i=0; i<3; i++) {
                mainNewsTextMap.put(i, elements.get(i).text());
            }
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("Can't connect to the URL. Sorry!");
        }

        if (mainNewsTextMap.isEmpty())
            {return false;}
        else
            {return true;}

    }

    @Override
    public void printNewItems() {
        for (int i=0; i<3; i++) {
            System.out.println(i + ". " + mainNewsTextMap.get(i));
        }
    }
}
