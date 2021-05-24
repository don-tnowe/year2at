package com.company;

public class Lab2 {

    private static final int sortCountExp = 10;

    private static int countComs = 0;
    private static int countSwaps = 0;

    private static void swap(int[] arr, int first, int second)
    {
        int swapBuffer = arr[first];
        arr[first] = arr[second];
        arr[second] = swapBuffer;
        countSwaps++;
    }

    public static int[] sortSelection(int[] arrSource) {
        countComs = 0;
        countSwaps = 0;
        int[] arr = arrSource.clone();
        int n = arr.length;
        long startTime = System.nanoTime();

        int min;
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

    public static int[] sortHeapsort(int[] arrSource) {
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

    private static void heapsortHeapify(int[] arr, int unsorted, int root) {
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

    public static int[] sortRadix(int[] arrSource) {
        countComs = 0;
        countSwaps = 0;

        int n = arrSource.length;
        int[] arr = arrSource.clone();
        long startTime = System.nanoTime();

        int largest = arr[0];
        for (int i = 1; i < n; ++i) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
            countComs ++;
        }

        for (int i = 1; largest / i > 0; i *= sortCountExp) {
            arr = sortDigitCount(arr, i);
        }

        Main.printTime(startTime);
        System.out.println("Comparisons:" + countComs + " Swaps: " + countSwaps);
        return arr;
    }

    public static int[] sortDigitCount(int[] arrSource, int digitExp)
    {
        int n = arrSource.length;
        int[] arr = arrSource.clone();

        int[] count = new int[sortCountExp];

        for (int i = 0; i < n; i++)
            count[(arr[i] / digitExp) % sortCountExp]++;

        for (int i = 1; i < sortCountExp; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            arr[count[(arrSource[i] / digitExp) % sortCountExp] - 1] = arrSource[i];
            count[(arrSource[i] / digitExp) % sortCountExp]--;
        }
        return arr;
    }
}
