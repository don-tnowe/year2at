package com.company;
import CGW.*;

public class CGW {
    public static void execute() {
        MealyMachine machineA = new MealyMachine(
                "12",
                new int[][][] {
                        {{'1', 1}, {'2', 2}},
                        {{'2', 3}, {'3', 1}},
                        {{'3', 3}, {'3', 1}},
                        {{'3', 0}, {'1', 1}}
                });
        System.out.println("   212122");
        System.out.println("-> " + machineA.processString("212122"));

        MooreMachine machineA1 = new MooreMachine(
                "12",
                "3132323",
                new int[][][] {
                        {{1}, {3}},
                        {{5}, {2}},
                        {{5}, {2}},
                        {{6}, {3}},
                        {{6}, {3}},
                        {{0}, {1}},
                        {{0}, {1}}
                });
        System.out.println("   212122");
        System.out.println("-> " + machineA1.processString("212122"));

        TuringMachine machineT13 = new TuringMachine(
                "01",
                new int[][][] {
                        {{'0', -1, 0}, {'1',  1, 1}},
                        {{'1',  1, 0}, {'0',  0, 2}},
                        {{'0',  1, 3}, {'1',  0, 4}},
                        {{'1', -1, 2}, {'1',  0, 6}},
                        {{'0',  1, 4}, {'0',  0, 5}},
                        {{'0',  0, -1}, {'1',  1, 5}},
                        {{'1',  1, 6}, {'0', -1, 7}},
                        {{'0',  1, 7}, {'1',  0, 0}}
                });

        System.out.println("   11010010101011010011");
        System.out.println("-> " + machineT13.processString("11010010101011010011"));
    }
}
