package org.local;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;

public class InputTest {

    @Test
    void parseFromString() {
        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";

        Document parse = Jsoup.parse(html);
        System.out.println(parse);
    }

    @Test
    void parsingBodyFragment() {
        String html = "<div><p>Lorem ipsum.</p>";
        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();

        System.out.println(body);
        // <body>
        // <div>
        // <p>Lorem ipsum.</p>
        // </div>
        // </body>
    }

    @Test
    void loadDocumentFromURL() throws IOException {
        String url = "https://en.wikipedia.org/wiki/Java";
        Document document = Jsoup.connect(url).get();
        String title = document.title();

        System.out.println(title); // Java - Wikipedia
        System.out.println(document.location()); // https://en.wikipedia.org/wiki/Java
        System.out.println(document.data());
        System.out.println(document.baseUri()); // https://en.wikipedia.org/wiki/Java
        System.out.println(document.getElementsByTag("img").first());
        // <img class="mw-logo-icon" src="/static/images/icons/wikipedia.png" alt=""
        // aria-hidden="true" height="50" width="50">

        // connection with chaining
        Document doc = Jsoup.connect(url)
                .data("query", "Java")
                .userAgent("Mozilla")
                .cookie("auth", "token")
                .timeout(3000)
                .get();

        System.out.println(doc.head()); // get head html
    }

    @Test
    void loadDocumentFromFile() throws IOException {
        File file = new File("index.html");
        Document doc = Jsoup.parse(file, "UTF-8");

        System.out.println(doc.title()); // Contoh HTML
        System.out.println(doc.body());
        System.out.println(doc.wholeText());
    }

}
