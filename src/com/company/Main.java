package com.company;
import java.math.*;
import java.util.Random;

public class Main {
    public static void printTime(long startTime) {
        long endTime = System.nanoTime();
        System.out.println("Nanoseconds: " + (endTime - startTime));
    }

    public static void execute(int idx, int[] param0) {
        Lab2 algs = new Lab2();
        System.out.println("Algorithm " + idx + ", array = " + arrayToString(param0));
        int[] result;
        switch (idx) {
            case 0 -> result = algs.sortSelection(param0);
            case 1 -> result = algs.sortHeapsort(param0);
            case 2 -> result = algs.sortRadix(param0);
            default -> throw new IllegalStateException("Unexpected value: " + idx);
        }
        System.out.println(arrayToString(result));
    }

    public static int[] generateArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++)
            arr[i] = Math.abs(random.nextInt()) % size;
        return arr;
    }

    public static String arrayToString(int[] arr) {
        StringBuilder returnValue = new StringBuilder();
        for (int j : arr) {
            returnValue.append(", " + j);
        }
        return returnValue.toString();
    }

    public static void main(String[] args) {
        int[] arr;
        arr = generateArray(10);
        execute(0, arr);
        execute(1, arr);
        execute(2, arr);
        System.out.println("");
        arr = generateArray(100);
        execute(0, arr);
        execute(1, arr);
        execute(2, arr);
        System.out.println("");
        arr = generateArray(1000);
        execute(0, arr);
        execute(1, arr);
        execute(2, arr);
        System.out.println("");
        arr = generateArray(10000);
        execute(0, arr);
        execute(1, arr);
        execute(2, arr);
        System.out.println("");
    }
}
