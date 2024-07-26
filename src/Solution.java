class Solution {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 3};

        System.out.println(findPeakIndex(arr));


    }

    static int findPeakIndex(int[] arr) {
        int lowIndex = 0, highIndex = arr.length - 1;

        while (lowIndex < highIndex) {
            int mid = lowIndex + ((highIndex - lowIndex) / 2);

            if (arr[mid] > arr[mid + 1]) {
                highIndex = mid;
            } else {
                lowIndex = mid + 1;
            }
        }

        return lowIndex;
    }

    // if ascending
    public static int findMax(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

}
