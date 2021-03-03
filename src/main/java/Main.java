import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final String folderPath = "Desktop"; // creating the path of the folder that you want to save the images to

    public static void main(String[] args) {

        Document doc;
        {
            try {
                doc = Jsoup.connect("https://lenta.ru/").get(); // connect to the website and get the html
                //System.out.println(doc);
                Elements elements = doc.select("img"); // get all elements with the tag img
                for (Element el: elements) {
                    String src = el.absUrl("src"); // for each element get the srs url
                    System.out.println("Image Found!");
                    System.out.println("src attribute is:  " + src);
                    getImages(src);
                }
            } catch (IOException e) {
                System.out.println("There was an error");
        }

    }


}

    private static void getImages(String src) throws IOException {
        String folder = null;
        int indexname = src.lastIndexOf("/"); //return index the last occurrences
        if (indexname == src.length()) { // if indexname equal length src
            src = src.substring(1, indexname); // src equal src from 1 to indexname
        }

        indexname = src.lastIndexOf("/"); // return index the last occurrences
        String name = src.substring(indexname, src.length()); // create variable name from indexname to length src

        System.out.println(name);

        URL url = new URL(src)

    }
    }
