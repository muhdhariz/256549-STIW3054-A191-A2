package com.github.muhdhariz;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class FollowerStatistic {
    private static ArrayList<Document> doc = new ArrayList<>();
    private static ArrayList<Elements> data = new ArrayList<>();
    private static String[][] info = {};
    static String[][] follStat = {};

    public static void main(String[] args) throws IOException {
        //FollowersList.main(args);
        follStat = new String[FollowersList.follLink.size()][6];
        info = new String[FollowersList.follLink.size()][5];
        new FollowerStatistic().Main();
    }

    public void Main() throws IOException {
        int d = 0;
        int E = 0;
        for (String ghLink : FollowersList.follLink) {
            doc.add(Jsoup.connect(ghLink).get());
            data.add(doc.get(d).getElementsByClass("Counter hide-lg hide-md hide-sm"));

            int i = 0;
            for (Element dataS : data.get(E)) {
                info[E][i] = dataS.text();
                i++;
            }
            follStat[E][0] = String.valueOf(E + 1);

            E++;
            d++;
        }

        int l = 0;
        for (String log : FollowersList.loginId) {
            String[] logS = log.split("/");
            for (String logSL : logS) {
                follStat[l][1] = logSL;
            }
            l++;
        }

        for (int i = 0; i < follStat.length; i++) {
            for (int j = 0; j < follStat[i].length; j++) {
                for (int k = 0; k < info[i].length; k++) {
                    if (k == 0 && j == 2) {
                        follStat[i][j] = info[i][k];
                    } else if (k == 3 && j == 3) {
                        follStat[i][j] = info[i][k];
                    } else if (k == 2 && j == 4) {
                        follStat[i][j] = info[i][k];
                    } else if (k == 4 && j == 5) {
                        follStat[i][j] = info[i][k];
                    }
                }
            }
        }

        for (String[] strings : follStat) {
            if (strings[2] != null) {
                for (String string : strings) {
                    System.out.print(string + " ");
                }
                System.out.println();
            }
        }
    }
}
