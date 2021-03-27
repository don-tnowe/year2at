package com.company;

import java.util.Arrays;

public class Lab2 {

    int countComs = 0;
    int countSwaps = 0;

    private void swap(int[] arr, int first, int second)
    {
        int swapBuffer = arr[first];
        arr[first] = arr[second];
        arr[second] = swapBuffer;
        countSwaps++;
    }

    public int[] sortSelection(int[] arrSource) {
        countComs = 0;
        countSwaps = 0;
        int[] arr = arrSource.clone();
        int n = arr.length;
        long startTime = System.nanoTime();
        int min = 0;
        for (int i = 0; i < n; ++i) {
            min = i;
            for (int j = i + 1; j < n; ++j) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
                countComs ++;
            }
            swap(arr, i, min);
        }
        Main.printTime(startTime);
        System.out.println("Comparisons:" + countComs + " Swaps: " + countSwaps);
        return arr;
    }

    public int[] sortHeapsort(int[] arrSource) {
        countComs = 0;
        countSwaps = 0;
        int[] arr = arrSource.clone();
        int n = arr.length;
        long startTime = System.nanoTime();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapsortHeapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapsortHeapify(arr, i, 0);
        }

        Main.printTime(startTime);
        System.out.println("Comparisons:" + countComs + " Swaps: " + countSwaps);
        return arr;
    }

    private void heapsortHeapify(int[] arr, int unsorted, int root) {
        int largest = root;
        int l = 2 * root + 1;
        int r = 2 * root + 2;

        if (l < unsorted && arr[l] > arr[largest])
            largest = l;
        if (r < unsorted && arr[r] > arr[largest])
            largest = r;
        if (largest != root) {
            swap(arr, root, largest);
            heapsortHeapify(arr, unsorted, largest);
        }
        countComs += 3;
    }

    public int[] sortRadix(int[] arrSource) {
        countComs = 0;
        countSwaps = 0;

        int n = arrSource.length;
        int[] arr = arrSource.clone();
        long startTime = System.nanoTime();

        int largestIdx = 0;
        int largest = arr[0];
        for (int i = 1; i < n; ++i) {
            if (arr[i] > largest) {
                largest = arr[i];
                largestIdx = i;
            }
            countComs ++;
        }

        for (int i = 1; largest / i > 0; i *= 10) {
            arr = sortDigitCount(arr, i);
        }

        Main.printTime(startTime);
        System.out.println("Comparisons:" + countComs + " Swaps: " + countSwaps);
        return arr;
    }

    public int[] sortDigitCount(int[] arrSource, int digitExp)
    {
        int n = arrSource.length;
        int[] arr = arrSource.clone();

        int[] count = new int[10];

        for (int i = 0; i < n; i++)
            count[(arr[i] / digitExp) % 10]++;

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            arr[count[(arrSource[i] / digitExp) % 10] - 1] = arrSource[i];
            count[(arrSource[i] / digitExp) % 10]--;
        }
        return arr;
    }
}
