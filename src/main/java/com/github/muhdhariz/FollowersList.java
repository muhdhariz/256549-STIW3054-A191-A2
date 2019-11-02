package com.github.muhdhariz;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

class FollowersList {

    static ArrayList<String> follLink = new ArrayList<>(), loginId = new ArrayList<>();
    private static ArrayList<String> ghLink = new ArrayList<>();
    private static ArrayList<Document> doc = new ArrayList<>();
    private static ArrayList<Elements> data = new ArrayList<>();


    static void Main() {
        arraylist(ghLink, doc);

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

    private static void arraylist(ArrayList<String> ghLink, ArrayList<Document> doc) {
        ghLink.add("https://github.com/zhamri?tab=followers");
        ghLink.add("https://github.com/zhamri?after=Y3Vyc29yOnYyOpK5MjAxOS0wMi0yMFQxMTo1NDozOCswODowMM4Cfdf_&tab=followers");
        ghLink.add("https://github.com/zhamri?after=Y3Vyc29yOnYyOpK5MjAxOC0wOS0xNFQxMTozNzozMiswODowMM4CPUKe&tab=followers");
        ghLink.add("https://github.com/zhamri?after=Y3Vyc29yOnYyOpK5MjAxNy0wOS0xM1QyMTo1MDoxMCswODowMM4BoGXN&tab=followers");


        for (String ghLinkL : ghLink) {
            try {
                doc.add(Jsoup.connect(ghLinkL).get());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
