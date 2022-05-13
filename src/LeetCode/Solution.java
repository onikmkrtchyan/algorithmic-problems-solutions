package LeetCode;

import java.util.*;

public class Solution {

    public static boolean isPalindrome(int x) {
        ArrayList<Integer> digits = new ArrayList<>();
        int lastDigit;
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;
        while (x > 0) {
            lastDigit = x % 10;
            x = x / 10;
            digits.add(lastDigit);
        }
        int digitsSize = digits.size();
        for (int i = 0; i < digitsSize / 2; i++) {
            if (digits.get(0).equals(digits.get(digits.size() - 1))) {
                digits.remove(0);
                digits.remove(digits.size() - 1);
            } else return false;

        }
        return true;
    }

    /**
     * Given an integer x, return true if x is palindrome integer.
     * <p>
     * An integer is a palindrome when it reads the same backward as forward.
     *
     * @param x
     * @return
     */
    public static boolean isPalindromeSecondSolution(int x) {
        ArrayList<Integer> digits = new ArrayList<>();
        int lastDigit;
        while (x > 0) {
            lastDigit = x % 10;
            x = x / 10;
            digits.add(lastDigit);
        }

        return isPalindrome(digits.get(0), digits.get(digits.size() - 1), digits);
    }

    /**
     * Recursive
     * <p>
     * Given an integer ,return true if is palindrome integer.
     *
     * @param first
     * @param last
     * @param arrayList
     * @return
     */
    public static boolean isPalindrome(int first, int last, ArrayList<Integer> arrayList) {
        if (first > last) {
            return true;
        }
        if (!arrayList.get(first).equals(arrayList.get(last))) {
            return false;
        }
        isPalindrome(++first, --last, arrayList);

        return true;
    }

    /**
     * Given an integer n, return the number of prime numbers that are strictly less than n.
     *
     * @param number
     * @return
     */
    static int countPrimes(int number) {
        boolean[] isChecked = new boolean[number];
        int retValue = number / 2;// odd numbers quantity
        if (number < 3) return 0;
        int sqrt = (int) Math.sqrt(number);
        for (int i = 3; i <= sqrt; i += 2) {
            if (!isChecked[i]) {
                for (int j = i * i; j < number; j += 2 * i) {
                    if (!isChecked[j]) {
                        --retValue;
                        isChecked[j] = true;
                    }
                }
            }
        }
        return retValue;
    }

    /**
     * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.
     * <p>
     * https://leetcode.com/problems/remove-element/
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int quantityElement = nums.length, temp, quantity = nums.length - 1;

        for (int i = 0; i <= quantity; ++i) {
            if (nums[i] == val) {
                temp = nums[quantity];
                nums[quantity] = nums[i];
                nums[i] = temp;
                --i;
                --quantityElement;
                --quantity;
            }
        }

        return quantityElement;
    }

    /**
     * Reverse bits of a given 32 bits unsigned integer.
     *
     * @param n
     * @return
     */
    public static int reverseBitsSecondSolution(int n) {
        int[] binaryValue = new int[32];
        for (int i = 31; i > 0; ) {
            int a = n % 2;
            n /= 2;
            binaryValue[i--] = a;
        }
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            sum += binaryValue[i] * Math.pow(2, i);
        }
        return sum;
    }

    /**
     * Given a signed 32-bit integer x, return x with its digits reversed.
     * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
     * <p>
     * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int retValue = 0;
        while (x != 0) {
            if (retValue > Integer.MAX_VALUE / 10 || retValue < Integer.MIN_VALUE / 10) {
                return 0;
            }
            retValue = retValue * 10 + x % 10;
            x /= 10;
        }
        return retValue;
    }

    /**
     * The valid parentheses problem with stack
     *
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
     * You are given a large integer represented as an integer array digits,
     * where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order.
     * The large integer does not contain any leading 0's.
     * Increment the large integer by one and return the resulting array of digits.
     *
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
     *
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[nums.length];
        for (int i = 1; i <= n; i++) {
            arr[2 * (i - 1)] = nums[i - 1];
            arr[2 * i - 1] = nums[i + n - 1];
        }
        return arr;
    }

    /**
     * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
     * you need to treat n as an unsigned value
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int retValue = 0;
        while (n != 0) {
            n = (n & n - 1);
            ++retValue;
        }
        return retValue;
    }

    /**
     * You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i-th customer has in the j-th bank.
     * Return the wealth that the richest customer has.
     * A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.
     *
     * @param accounts
     * @return
     */
    public int maximumWealth(int[][] accounts) {
        int retValue = 0, sum = 0;
        for (int[] account : accounts) {
            for (int i : account) {
                sum = sum + i;
            }
            if (sum > retValue) {
                retValue = sum;
            }
            sum = 0;
        }
        return retValue;
    }

    /**
     * Given a valid (IPv4) IP address, return a defanged version of that IP address.
     * <p>
     * A defanged IP address replaces every period "." with "[.]".
     *
     * @param address
     * @return
     */
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                sb.append("[.]");
            } else sb.append(address.charAt(i));
        }
        return sb.toString();
    }

    /**
     * return true if array contains duplicate value, else return false
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (integerSet.contains(nums[i])) {
                return true;
            } else
                integerSet.add(nums[i]);
        }
        return false;
    }

    /**
     * return true if number is power of 2, else return false
     * given 3 different solutions for this problem
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwoFirstSolution(int n) {
        int count = 0;
        if (n < 1)
            return false;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1)
                ++count;
            n >>= 1;
        }
        return count == 1;
    }

    //else easy solution
    public boolean isPowerOfTwoSecondSolution(int n) {
        return (((n & (n - 1)) == 0 && n > 0));
    }

    //else recursion
    public boolean isPowerOfTwoThirdSolution(int n) {
        if (n == 1)
            return true;
        if (n == 0)
            return false;
        if (n % 2 == 1)
            return false;
        return isPowerOfTwoThirdSolution(n / 2);
    }

    /**
     * return true if number is power of 3, else return false
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        if (n == 1)
            return true;
        if (n % 3 == 1 || n % 3 == 2 || n % 2 == 0)
            return false;

        return isPowerOfThree(n / 3);
    }

    /**
     * return true if number is power of 4, else return false
     *
     * @param n
     * @return
     */
    public boolean isPowerOfFour(int n) {
        if (n == 1)
            return true;
        if (n == 0 || n % 2 == 1 || n % 4 == 1 || n % 4 == 2 || n % 4 == 3)
            return false;

        return isPowerOfFour(n / 4);

    }

    /**
     * Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.
     * <p>
     * An integer y is a power of three if there exists an integer x such that y == 3x.
     *
     * @param n
     * @return
     */
    boolean checkPowersOfThree(int n) {
        ArrayList<Integer> powersOfThree = new ArrayList<>();
        powersOfThree.add(5);
        int j = 0;
        if (isPowerOfThree(n))
            return true;
        for (int i = 1; i <= n; i += 2) {
            if (isPowerOfThree(i)) {
                for (; j < powersOfThree.size(); ) {
                    powersOfThree.add(j, i);
                    break;
                }
                ++j;
            }
        }
        powersOfThree.remove(powersOfThree.size() - 1);

        for (int i = powersOfThree.size() - 1; i >= 0; --i) {
            if (n - powersOfThree.get(i) > 0) {
                n = n - powersOfThree.get(i);
            } else if (n - powersOfThree.get(i) == 0)
                return true;
        }
        return false;
    }

    /**
     * else simple and quick solution
     * Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.
     * <p>
     * An integer y is a power of three if there exists an integer x such that y == 3x.
     *
     * @param n
     * @return
     */
    boolean checkPowersOfThreeSecondSolution(int n) {
        while (n > 0) {
            if (n % 3 == 0 || n % 3 == 1)
                n /= 3;
            else
                return false;
        }
        return true;
    }

    /**
     * There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has,
     * and an integer extraCandies, denoting the number of extra candies that you have.
     * <p>
     * Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies,
     * they will have the greatest number of candies among all the kids, or false otherwise.
     * <p>
     * Note that multiple kids can have the greatest number of candies.
     *
     * @param candies
     * @param extraCandies
     * @return
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        Boolean[] arr = new Boolean[candies.length];
        for (int i = 0; i < candies.length; i++) {
            arr[i] = true;
        }

        for (int i = 0; i < candies.length; i++) {
            for (int j = 0; j < candies.length; j++) {
                if (candies[i] + extraCandies < candies[i]) {
                    arr[i] = false;
                }
            }
        }
        return Arrays.asList(arr);
    }

    /**
     * Return length of last word
     *
     * @param s s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int retVal = 0;
        for (int i = s.length() - 1; i >= 0; ) {
            if (s.charAt(i) != ' ') {
                ++retVal;
                if (--i < 0)
                    break;
                if (s.charAt(i) == ' ')
                    break;
            } else if (--i < 0)
                break;
        }
        return retVal;
    }

    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     * <p>
     * If there is no common prefix, return an empty string "".
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        Arrays.sort(strs);
        int c = 0;
        while (c < strs[0].length()) {
            if (strs[0].charAt(c) == strs[strs.length - 1].charAt(c))
                c++;
            else
                break;
        }
        return strs[0].substring(0, c);
    }

    //My solution something else
    public String longestCommonPrefixSecondSolution(String[] strs) {
        Arrays.sort(strs);
        int repeat = 0;
        int[] count = new int[strs.length];
        for (int i = 1; i < strs.length; ++i) {
            for (int j = 0; j < strs[i - 1].length(); ) {
                if (strs[i - 1].charAt(j) == strs[i].charAt(j)) {
                    ++j;
                    repeat = j;
                } else break;
            }
            count[i - 1] = repeat;
            repeat = 0;
        }

        int max = count[0], index = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max)
                max = count[i];
            if (count[i] == max)
                index = i;
        }
        if (max == 0) return "";
        else
            return strs[index].substring(0, max);
    }

    /**
     * return quantity of zeros in n factorial
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int retVal = 0;
        while (n > 0) {
            n /= 5;
            retVal += n;
        }
        return retVal;
    }

    /**
     * Remove duplicate numbers
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int retVal = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[retVal])
                nums[++retVal] = nums[i];
        }
        return ++retVal;
    }

    /**
     * Reverse bits of a given 32 bits unsigned integer.
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {

        int retValue = 0;

        for (int i = 0; i < 32; i++) {
            retValue = retValue << 1;
            retValue = retValue | (n & 1);
            n = n >> 1;
        }

        return retValue;
    }

    /**
     * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
     * Return the running sum of nums.
     *
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            nums[i] += nums[i - 1];
        return nums;
    }

    /**
     * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     * <p>
     * You must implement a solution with a linear runtime complexity and use only constant extra space.
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int retValue = 0;
        if (nums.length == 1)
            return nums[0];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                retValue = nums[i];
                break;
            } else retValue = nums[nums.length - 1];
        }
        return retValue;
    }

    //else solution in O(n)
    public int singleNumberSecondSolution(int[] nums) {
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s = s ^ nums[i];
        }
        return s;
    }

    /**
     * calculate root of x
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int retValue = 0;
        if (x >= 1)
            retValue++;
        else
            return 0;
        for (; retValue * retValue <= x; ++retValue) {
            if (retValue > Integer.MAX_VALUE / retValue)
                break;
        }
        return --retValue;
    }

    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * <p>
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * <p>
     * You can return the answer in any order.
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] retArr = new int[2];

        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    retArr[0] = i;
                    retArr[1] = j;
                    return retArr;
                }
            }

        }
        return retArr;
    }

    /**
     * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int bil = haystack.length();
        int sml = needle.length();
        if (0 == sml)
            return 0;
        else if (0 == bil)
            return -1;
        for (int i = 0; i < bil - sml + 1; i++) {
            if (haystack.substring(i, i + sml).equals(needle))
                return i;
        }
        return -1;
    }
}

