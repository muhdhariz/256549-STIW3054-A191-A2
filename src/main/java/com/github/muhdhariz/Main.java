package com.github.muhdhariz;

public class Main {
    private static Thread foll = new FollowersList();
    public static void main(String[] args) {
        foll.start();

    }
}
