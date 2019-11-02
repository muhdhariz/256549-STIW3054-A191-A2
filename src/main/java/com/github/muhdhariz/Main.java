package com.github.muhdhariz;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static String[][] Output = {};

    public static void main(String[] args) throws IOException {
        FollowersList.Main();
        Output = new String[FollowersList.follLink.size() + 2][6];
        int countCore = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(countCore);
        Output[0] = new String[]{"No.", "login id", "Number of repositories", "Number of followers", "Number of stars", "Number of following"};

        System.out.printf("| %-3s | %-20s | %-22s | %-19s | %-15s | %-19s |%n", Output[0][0], Output[0][1], Output[0][2], Output[0][3], Output[0][4], Output[0][5]);
        System.out.printf("|%5s|%22s|%24s|%21s|%17s|%21s|%n", "-----", "----------------------", "------------------------", "---------------------", "-----------------", "---------------------");
        for (int i = 0; i < FollowersList.follLink.size(); i++) {
            Thread t = new FollowerStatistic(i);
            service.execute(t);
            t.start();

            Output[i + 1] = new String[]{FollowerStatistic.follStat[i][0], FollowerStatistic.follStat[i][1], FollowerStatistic.follStat[i][2],
                    FollowerStatistic.follStat[i][3], FollowerStatistic.follStat[i][4], FollowerStatistic.follStat[i][5]};
            System.out.printf("| %-3s | %-20s | %-22s | %-19s | %-15s | %-19s |%n", Output[i + 1][0], Output[i + 1][1], Output[i + 1][2], Output[i + 1][3], Output[i + 1][4], Output[i + 1][5]);
        }
        service.shutdown();

        Excel.main(args);
    }
}
