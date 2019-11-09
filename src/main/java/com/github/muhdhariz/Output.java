package com.github.muhdhariz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Output {
    static String[][] Output = {};

    static void main() {
        Output = new String[StoreFollowersLink.follLink.size() + 2][6];
        int countCore = Runtime.getRuntime().availableProcessors();
        final ExecutorService service = Executors.newFixedThreadPool(countCore);

        Output[0] = new String[]{"No.", "login id", "Number of repositories", "Number of followers", "Number of stars", "Number of following"};
        System.out.printf("| %-3s | %-20s | %-22s | %-19s | %-15s | %-19s |%n", Output[0][0], Output[0][1], Output[0][2], Output[0][3], Output[0][4], Output[0][5]);
        System.out.printf("|%5s|%22s|%24s|%21s|%17s|%21s|%n", "-----", "----------------------", "------------------------", "---------------------", "-----------------", "---------------------");

        for (int i = StoreFollowersLink.follLink.size() - 1, j = 0; i >= 0; i--) {
            Thread t = new GetFollowersStatistic(i, j++);
            service.execute(t);
            t.start();

            Output[j] = new String[]{GetFollowersStatistic.follStat[i][0], GetFollowersStatistic.follStat[i][1], GetFollowersStatistic.follStat[i][2],
                    GetFollowersStatistic.follStat[i][3], GetFollowersStatistic.follStat[i][4], GetFollowersStatistic.follStat[i][5]};
            System.out.printf("| %-3s | %-20s | %-22s | %-19s | %-15s | %-19s |%n", Output[j][0], Output[j][1], Output[j][2], Output[j][3], Output[j][4], Output[j][5]);
        }
        service.shutdown();
    }
}
