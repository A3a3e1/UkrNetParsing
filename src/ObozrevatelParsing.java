import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by paulvoropaiev on 1/4/15.
 */
public class ObozrevatelParsing implements Parsable {

    Set<String> mainNewsTextSet = new HashSet<>();
    String urlToParse = "http://obozrevatel.com/author/slava-rabinovich.htm";
    int newsNumber;


    @Override
    public Set<String> parse(int x) {

        Document doc;
        Elements elements;
        newsNumber = x;

        try {
            doc = Jsoup.connect(urlToParse).get();
            elements = doc.select("div.ttl");
            for (int i=1; i<=newsNumber; i++) {
                mainNewsTextSet.add(elements.get(i).text());
            }
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("Can't connect to the URL. Sorry!");
        }

//        if (mainNewsTextSet.isEmpty())
//        {return false;}
//        else
//        {return true;}

        return mainNewsTextSet;
    }

    @Override
    public void printNewItems() {
        for (String v : mainNewsTextSet) {
            System.out.println(v);
        }
    }
}
