package com.github.muhdhariz;

import java.util.ArrayList;

class StoreFollowersStatistic {

    StoreFollowersStatistic(ArrayList<String> loginId, String[][] follStat, String[][] info, int E) {

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
