// Java code to print all possible subarrays for given array
// using recursion
public class SubArrays {

    // Recursive function to print all possible subarrays
    // for given array
    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3 };
        printSubArrays(arr, 0, 0);

    }

    static void printSubArrays(int[] arr, int start, int end)
    {
        // Stop if we have reached the end of the array
        if (end == arr.length)
            return;
            // Increment the end point and start from 0
        else if (start > end)
            printSubArrays(arr, 0, end + 1);
            // Print the subarray and increment the starting
            // point
        else {
            System.out.print("[");
            for (int i = start; i < end; i++)
                System.out.print(arr[i] + ", ");
            System.out.println(arr[end] + "]");
            printSubArrays(arr, start + 1, end);
        }
        return;
    }

    // Java program to generate all possible subarrays/subArrays
// Complexity- O(n^3) */
        static int arr[] = new int[]{1, 2, 3, 4};

        // Prints all subarrays in arr[0..n-1]
        static void subArray( int n)
        {
            // Pick starting point
            for (int i=0; i <n; i++)
            {
                // Pick ending point
                for (int j=i; j<n; j++)
                {
                    // Print subarray between current starting
                    // and ending points
                    for (int k=i; k<=j; k++)
                        System.out.print(arr[k]+" ");
                }
            }
        }
}
