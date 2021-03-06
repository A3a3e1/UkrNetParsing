import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by paulvoropaiev on 1/4/15.
 */
public class UkrNetParsing implements Parsable {

    public UkrNetParsing(/*int x*/) {
//        parse(x);
    }

    Set<String> mainNewsTextSet = new HashSet<>();
    String urlToParse = "https://www.ukr.net/";
    int newsNumber;


    @Override
    public Set<String> parse(int x) {

        Document doc;
        Elements elements;
        newsNumber = x;

        try {
            doc = Jsoup.connect(urlToParse).get();
            elements = doc.select("div > h3 > a");
            for (int i=3; i<8/*newsNumber*/; i++) {
                mainNewsTextSet.add(elements.get(i).text());
            }
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("Can't connect to the URL. Sorry!");
        }

//        if (mainNewsTextSet.isEmpty())
//            {return false;}
//        else
//            {return true;}

        return mainNewsTextSet;

    }

    @Override
    public void printNewItems() {
        for (String s : mainNewsTextSet) {
            System.out.println(s);
        }
    }
}
