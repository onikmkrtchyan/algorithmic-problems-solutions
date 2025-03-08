package binary_search;

public class Solution {
    public static int bin(int[] arr, int t) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == t) {
                return mid;
            }

            if (arr[mid] > t) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }

        return -1;
    }

    public static int binR(int[] arr, int t, int l, int r) {
        if (r < l) {
            return -1;
        }

        int mid = l + (r - l) / 2;

        if (arr[mid] == t) {
            return mid;
        }

        if (arr[mid] > t) {
            return binR(arr, t, l, mid - 1);
        } else {
            return binR(arr, t, mid + 1, r);
        }
    }

    //Find Minimum in Rotated Sorted Array
    public static int findMin(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int res = arr[0];

        while (l < r) {
            if (arr[l] < arr[r]) {// already sorted
                res = Math.min(res, arr[l]);
                break;
            }

            int mid = l + (r - l) / 2;
            res = Math.min(res, arr[mid]);
            if (arr[mid] >= arr[l]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }

        return res;
    }

    private static int findMinRecursive(int[] arr, int left, int right, int res) {
        if (left >= right) {
            return Math.min(res, arr[left]);
        }

        if (arr[left] < arr[right]) {
            return Math.min(res, arr[left]);
        }

        int mid = left + (right - left) / 2;
        res = Math.min(res, arr[mid]);

        if (arr[mid] >= arr[left]) {
            return findMinRecursive(arr, mid + 1, right, res);
        } else {
            return findMinRecursive(arr, left, mid - 1, res);
        }
    }

    public static void main(String[] args) {

        System.out.println(bin(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 9));

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int l = 0;
        int r = arr.length - 1;
        System.out.println(binR(arr, 9, l, r));

        int[] arr2 = {3, 4, 5, 6, 1, 2};
        System.out.println(findMin(arr2));

        System.out.println(findMinRecursive(arr2, 0, arr2.length - 1, arr2[0]));

    }
}
