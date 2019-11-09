package com.github.muhdhariz;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

class StoreFollowersLink {
    static ArrayList<String> follLink = new ArrayList<>(), loginId = new ArrayList<>();
    private static ArrayList<String> ghLink = new ArrayList<>();
    private static ArrayList<Document> doc = new ArrayList<>();
    private static ArrayList<Elements> data = new ArrayList<>();


    static void Main() {
        new GetFollowerLink(ghLink, doc);

        int E = 0;
        int l = 0;
        for (Document docA : doc) {
            data.add(docA.getElementsByClass("d-inline-block no-underline mb-1"));

            for (Element datas : data.get(E)) {
                assert loginId != null;
                loginId.add(datas.attr("href"));
                follLink.add("https://github.com" + loginId.get(l));
                l++;
            }
            E++;
        }
    }

    public static void main(String[] args) {
        Main();
        for (String foll : follLink) {
            System.out.println(foll);
        }
    }
}
