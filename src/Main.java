import LeetCode.Solution;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        int[] arr = { 1, 5, 7, -1, 5, 8};
        int[] arr1 = {2, 3};
        int[] arr2 = {4, 1};
        String num1 = Arrays.toString(arr1).replace(",", "").replace("[", "").replace("]", "").replace(" ", "");
        String num2 = Arrays.toString(arr2).replace(",", "").replace("[", "").replace("]", "").replace(" ", "");

        System.out.println(Solution.convert("PAYPALISHIRINGAGAIN", 5));

//        System.out.println(Solution.multiply(num1, num2));
//        System.out.println("hi");
    }
}
