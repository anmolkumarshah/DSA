package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static int pivot(int[] arr, int l, int h) {
        int pivot = arr[l];
        int i = l;
        int j = h;

        do {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i < j) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        } while (i < j);
        int temp = arr[j];
        arr[j] = arr[l];
        arr[l] = temp;

        return j;
    }

    public static void quickSort(int[] arr, int l, int h) {
        if (l < h) {
            int pivot = pivot(arr, l, h);
            quickSort(arr, l, pivot);
            quickSort(arr, pivot + 1, h);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1, 1000 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
