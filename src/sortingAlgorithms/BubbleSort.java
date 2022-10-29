package sortingAlgorithms;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 1, 0, -10, 5, 6, 8, -15};
//        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }

    /**
     * Bubble Sort has time complexity of O(n^2).
     *
     * @param arr arr
     * @return sorted arr
     */
    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    Tools.swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }
}
