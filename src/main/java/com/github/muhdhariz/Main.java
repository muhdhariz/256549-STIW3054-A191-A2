package com.github.muhdhariz;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static StoreFollowersLink followersList = new StoreFollowersLink();
    private static Excel excel = new Excel();
    private static Output output = new Output();

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        followersList.Main();

        output.main();

        excel.main(args);
    }
}