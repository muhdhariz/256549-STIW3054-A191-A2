package com.github.muhdhariz;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.concurrent.Callable;

class GetFollowersStatistic implements Callable<String[][]> {
    private static int E;
    private static int no;

    GetFollowersStatistic(int i, int n) {
        E = i;
        no = n;
    }

    public String[][] call() {
        String[][] follStat;
        synchronized (this) {
            follStat = new String[StoreFollowersLink.follLink.size()][6];
            String[][] info = new String[StoreFollowersLink.follLink.size()][5];

            Document doc = null;
            try {
                doc = Jsoup.connect(StoreFollowersLink.follLink.get(E)).timeout(0).get();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Cannot connect to the link");
            }

            assert doc != null;
            Elements data = doc.getElementsByClass("Counter hide-lg hide-md hide-sm");

            int i = 0;
            for (Element dataS : data) {
                info[E][i] = dataS.text();
                i++;
            }

            follStat[E][0] = String.valueOf(no + 1);

            new StoreFollowersStatistic(StoreFollowersLink.loginId, follStat, info, E);
        }
        return follStat;
    }
}
