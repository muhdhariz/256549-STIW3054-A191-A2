package com.github.muhdhariz;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class FollowersList extends Thread {

    public static ArrayList<String> foll = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        new FollowersList().Main();
    }

    public void Main() throws IOException {
        String[] ghLink = {"https://github.com/zhamri?tab=followers", "https://github.com/zhamri?after=Y3Vyc29yOnYyOpK5MjAxOS0wMi0yMFQxMTo1NDozOCswODowMM4Cfdf_&tab=followers",
                "https://github.com/zhamri?after=Y3Vyc29yOnYyOpK5MjAxOC0wOS0xNFQxMTozNzozMiswODowMM4CPUKe&tab=followers", "https://github.com/zhamri?after=Y3Vyc29yOnYyOpK5MjAxNy0wOS0xM1QyMTo1MDoxMCswODowMM4BoGXN&tab=followers"};

        int d = 0;
        Document[] doc = new Document[ghLink.length];
        for (String ghLinkA : ghLink) {
            doc[d] = Jsoup.connect(ghLinkA).get();
            d++;
        }

        int E = 0;
        int totalF = 0;
        Elements[] data = new Elements[doc.length];
        for (Document docA : doc) {
            data[E] = docA.getElementsByClass("d-inline-block no-underline mb-1");

            for (Element datas : data[E]) {
                String theLink = datas.attr("href");
                if (theLink != null) {
                    totalF++;
                    foll.add("https://github.com" + theLink);
                }
            }
            E++;
        }

        System.out.println(totalF);
        for (String follL : foll) {
            System.out.println(follL);
        }
    }
}
