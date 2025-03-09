package sorting_algorithms;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {7, 6, 4, 5, 3, 1};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(sort(arr)));
    }

    /**
     * Insertion Sort has time complexity of O(n^2).
     * @param arr arr
     * @return sorted array
     */
    static int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            int j = i - 1;

            while (j >= 0 && arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
                j--;
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int fromIndex, int toIndex) {
        int temp = arr[fromIndex];
        arr[fromIndex] = arr[toIndex];
        arr[toIndex] = temp;
    }
}
