package com.company;

public class Module1 {
    public static void execute(int count) {
        int x = 0;
        int i = 0;
        long startTime = System.nanoTime();
        while (i < count) {
            x = x + 5;
            i++;
            System.out.println(x);
        }
        Main.printTime(startTime);
    }
}
