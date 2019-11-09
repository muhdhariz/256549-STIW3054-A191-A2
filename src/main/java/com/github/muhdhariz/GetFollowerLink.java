package com.github.muhdhariz;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

class GetFollowerLink {

    GetFollowerLink(ArrayList<String> ghLink, ArrayList<Document> doc) {
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
