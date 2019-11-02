package com.github.muhdhariz;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

class FollowerStatistic extends Thread implements Runnable {
    static String[][] follStat = {};
    private static int E;

    FollowerStatistic(int i) {
        E = i;
    }

    public void start() {
        synchronized (this) {
            follStat = new String[FollowersList.follLink.size()][6];
            String[][] info = new String[FollowersList.follLink.size()][5];

            Document doc = null;
            try {
                doc = Jsoup.connect(FollowersList.follLink.get(E)).timeout(0).get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            assert doc != null;
            Elements data = doc.getElementsByClass("Counter hide-lg hide-md hide-sm");

            int i = 0;
            for (Element dataS : data) {
                info[E][i] = dataS.text();
                i++;
            }

            follStat[E][0] = String.valueOf(E + 1);

            arraylist(FollowersList.loginId, follStat, info);
        }
    }

    private static void arraylist(ArrayList<String> loginId, String[][] follStat, String[][] info) {

        String[] logS = loginId.get(E).split("/");
            for (String logSL : logS) {
                follStat[E][1] = logSL;
            }


        for (int j = 0; j < follStat[E].length; j++) {
            for (int k = 0; k < info[E].length; k++) {
                    if (k == 0 && j == 2) {
                        follStat[E][j] = info[E][k];
                    } else if (k == 3 && j == 3) {
                        follStat[E][j] = info[E][k];
                    } else if (k == 2 && j == 4) {
                        follStat[E][j] = info[E][k];
                    } else if (k == 4 && j == 5) {
                        follStat[E][j] = info[E][k];
                    }
                }
            }
    }
}
