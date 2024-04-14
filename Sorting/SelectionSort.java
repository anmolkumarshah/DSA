package Sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            int k = i;

            while (j < arr.length) {
                if (arr[j] < arr[k]) {
                    k = j;
                }
                j++;
            }

            int temp = arr[k];
            arr[k] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
