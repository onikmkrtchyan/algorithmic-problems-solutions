package LeetCode;

import java.util.Stack;

public class Solution {

    /**
     * The valid parentheses problem with stack
     * @param s
     * @return
     */
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (!stack.isEmpty() && ((s.charAt(i) == '}' && stack.peek() == '{') || (s.charAt(i) == ']' && stack.peek() == '[') ||
                    (s.charAt(i) == ')' && stack.peek() == '('))) {
                stack.pop();
            } else return false;
        }
        return stack.isEmpty();
    }

    /**
     *You are given a large integer represented as an integer array digits,
     * where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order.
     * The large integer does not contain any leading 0's.
     * Increment the large integer by one and return the resulting array of digits.
     * @param digits
     * @return
     */
    public int[] arrayPlusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; --i) {
            if (9 == digits[i]) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        int[] digitsPlusOne = new int[digits.length + 1];
        for (int i = 1; i < digitsPlusOne.length; ++i)
            digitsPlusOne[i] = 0;
        digitsPlusOne[0] = 1;
        return digitsPlusOne;
    }

    /**
     * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
     * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[nums.length];
        for (int i = 1; i <= n; i++) {
            arr[2 * (i - 1)] = nums[i-1];
            arr[2 * i - 1] = nums[i + n-1];
        }
        return arr;
    }

    /**
     *
     * you need to treat n as an unsigned value
     * @param n
     * @return
     */
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

        int retValue = 0;
        while (n !=0){
            n = (n & n-1);
            ++retValue;
        }
        return retValue;
    }

}
