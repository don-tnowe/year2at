package com.company;
import java.util.Random;

public class Main {
    public static void printTime(long startTime) {
        long endTime = System.nanoTime();
        System.out.println("Nanoseconds: " + (endTime - startTime));
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
        executeCGW();
    }

    public static void executeL1(int alg, int param) {
        Lab1 algs = new Lab1();
        System.out.println("Algorithm: " + alg + ", input = " + param);
        String result;
        switch (alg) {
            case 1 -> result = algs.alg1(param);
            case 2 -> result = algs.alg2(param);
            default -> throw new IllegalStateException("Unexpected value: " + alg);
        }
        System.out.println(result);
    }

    public static void executeL2(String alg, int[] param0) {
        System.out.println("Algorithm: " + alg + ", array = " + arrayToString(param0));
        int[] result;
        switch (alg) {
            case "sortSelection" -> result = Lab2.sortSelection(param0);
            case "sortHeapsort" -> result = Lab2.sortHeapsort(param0);
            case "sortRadix" -> result = Lab2.sortRadix(param0);
            default -> throw new IllegalStateException("Unexpected value: " + alg);
        }
        System.out.println(arrayToString(result));
    }

    public static void executeL3(String filename) {
        System.out.println("File: " + filename);
        Lab3.readFile(filename);
        Lab3.print();
        System.out.println("File: " + filename + " With 'or' printed between words");
        Lab3.readFile(filename);
        Lab3.removeOrPlaceConnector("or");
        Lab3.print();
    }

    public static void executeModule() {
        Module1.execute(200000);
    }

    public static void executeL4() {
        Lab4.execute();
    }

    public static void executeL5() {
        Lab5.execute();
    }

    public static void executeCGW() {
        CGW.execute();
    }
}
