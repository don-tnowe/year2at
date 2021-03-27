package com.company;

public class Prac1{

    public int alg1(int[] X) {
        int maxFound = 0;
        for (int L = 0; L < X.length; L++)
            for (int U = L; U < X.length; U++) {
                int sum = 0;
                for (int i = L; i < U; i++)
                    sum += X[i];
                maxFound = Math.max(maxFound, sum);
            }
        return maxFound;
    }
    public int alg2(int[] X) {
        int maxFound = 0;
        for (int L = 0; L < X.length; L++) {
            int sum = 0;
            for (int U = L; U < X.length; U++) {
                sum += X[U];
                maxFound = Math.max(maxFound, sum);
            }
        }
        return maxFound;
    }
}
