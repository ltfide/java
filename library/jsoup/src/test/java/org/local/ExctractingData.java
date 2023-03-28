package org.local;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

public class ExctractingData {

    @Test
    void domNavigateDoc() throws IOException {
        File input = new File("index.html");
        Document document = Jsoup.parse(input, "UTF-8");

        Element content = document.getElementById("content");
        Elements links = content.getElementsByTag("a");

        for (Element link : links) {
            String linkHref = link.attr("href");
            String linkText = link.text();
            System.out.println(linkHref);
            System.out.println(linkText);
        }

        // output
        // /https://www.google.com
        // Google
        // /https://www.amazon.com
        // Amazon
        // /https://www.tesla.com
        // Tesla
        // /https://www.bing.com
        // Bing
        // /https://www.instagram.com
        // Instagram
    }

}
