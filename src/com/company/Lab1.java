package com.company;

public class Lab1 {
    //Побудувати алгоритм, який набиратиме суму N копійок
    // з набору монет 1, 2, 5,10, 25 та 50 копійок.
    public String alg1(int n) {
        int numberLeft = n;
        int[] used = {0, 0, 0, 0, 0, 0};
        long startTime = System.nanoTime();
        while (numberLeft != 0)
            if (numberLeft > 50) {
                numberLeft -= 50;
                ++used[0];
            }
            else if (numberLeft >= 25) {
                numberLeft -= 25;
                ++used[1];
            }
            else if (numberLeft >= 10) {
                numberLeft -= 10;
                ++used[2];
            }
            else if (numberLeft >= 5) {
                numberLeft -= 5;
                ++used[3];
            }
            else if (numberLeft >= 2) {
                numberLeft -= 2;
                ++used[4];
            }
            else {
                numberLeft -= 1;
                ++used[5];
            }
        Main.printTime(startTime);
        return (
                n + " = "
                        + used[0] + " * 50, "
                        + used[1] + " * 25, "
                        + used[2] + " * 10, "
                        + used[3] + " * 5, "
                        + used[4] + " * 2, "
                        + used[5] + " * 1"
        );
    }
    public String alg2(int n) {
        int[] used = {0, 0, 0, 0, 0, 0};
        long startTime = System.nanoTime();
        used[0] = n / 50;
        used[1] = (n % 50 / 25);
        used[2] = (n % 25 / 10);
        int leftover = (n % 25 - used[2] * 10) % 10;
        used[3] = leftover / 5;
        leftover %= 5;
        used[4] = leftover / 2;
        used[5] = leftover % 2;
        Main.printTime(startTime);
        return (
                n + " = "
                        + used[0] + " * 50, "
                        + used[1] + " * 25, "
                        + used[2] + " * 10, "
                        + used[3] + " * 5, "
                        + used[4] + " * 2, "
                        + used[5] + " * 1"
        );
    }
}
