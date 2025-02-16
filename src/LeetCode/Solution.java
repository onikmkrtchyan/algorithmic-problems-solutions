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

    public boolean containsDuplicate3(int[] nums) {
        Set<Integer> integerSet = new HashSet<>();
        for (int num : nums) {
            if (!integerSet.add(num)) { // add returns false if the element is already present
                return true;
            }
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
    static int[] twoSum(int[] nums, int target) {
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

    /**
     * Given an integer number n
     * Return the difference between the product of its digits and the sum of its digits.
     *
     * @param n number
     * @return difference between the product of n's digits and the sum of its digits
     */
    public static int subtractProductAndSum(int n) {
        int sum = 0, product = 1, lastDigit;

        while (n != 0) {
            lastDigit = n % 10;
            product *= lastDigit;
            sum += lastDigit;
            n /= 10;
        }

        return product - sum;
    }

    /**
     * Given two non-negative integers num1 and num2 represented as strings,
     * return the product of num1 and num2, also represented as a string.
     * You must not use any built-in BigInteger library or convert the inputs to integer directly
     *
     * @param num1 non negative integer
     * @param num2 non negative integer
     * @return the product of num1 and num2, also represented as a string
     */
    public static String multiply(String num1, String num2) {
        int numOneLength = num1.length(), numTwoLength = num2.length(), mul, p1, p2, sum;
        int[] pos = new int[numOneLength + numTwoLength];

        for (int i = numOneLength - 1; i >= 0; i--) {
            for (int j = numTwoLength - 1; j >= 0; j--) {
                mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                p1 = i + j;
                p2 = i + j + 1;

                sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder retValue = new StringBuilder();
        for (int p : pos) if (!(p == 0 && retValue.length() == 0)) retValue.append(p);
        return retValue.length() == 0 ? "0" : retValue.toString();
    }

    /**
     * Problem is to find count of pairs with given sum.
     *
     * @param arr given array
     * @param n   arr length
     * @param k   given sum
     * @return count of pairs with given sum
     */
    static int getPairsCount(int[] arr, int n, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (m.containsKey(k - arr[i])) {
                count += m.get(k - arr[i]);
            }
            if (m.containsKey(arr[i])) {
                m.put(arr[i], m.get(arr[i]) + 1);
            } else {
                m.put(arr[i], 1);
            }
        }
        return count;
    }

    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
     * (you may want to display this pattern in a fixed font for better legibility)
     * example located at the end of solution
     *
     * @param s       string word
     * @param numRows number of rows for result
     * @return string
     */
    public static String convert(String s, int numRows) {
        int sLength = s.length();
        if (numRows == 1 || numRows >= sLength) {
            return s;
        }

        StringBuilder retStr = new StringBuilder();
        int diff = 2 * (numRows - 1);

        for (int j = 0; j < numRows; j++) {
            for (int i = 0; i + j < sLength; i += diff) {
                retStr.append(s.charAt(i + j));
                if (j != 0 && j != numRows - 1 && i + diff - j < sLength) {
                    retStr.append(s.charAt(i + diff - j));
                }
            }
        }

        return retStr.toString();

/*
            PAYPALISHIRINGAGAIN
            0123456789021345678

            P       H       A
            A     S I     G I
            Y   I   R   A   N
            P L     I G
            A       N

*/
    }

    public static int searchInsert(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if (nums[midIndex] == target) return midIndex;
            else if (nums[midIndex] > target) endIndex = midIndex - 1;
            else startIndex = midIndex + 1;
        }

        return startIndex;
    }

    private static int lo, maxLen;

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i + 1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private static void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }

        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

    public static boolean containsDuplicate1(int[] nums) {
        Set<Integer> noDuplicates = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; i--)
            noDuplicates.add(nums[i]);

        return noDuplicates.size() != nums.length;
    }

    public static int searchInsert1(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (endIndex >= startIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if (nums[midIndex] == target) return midIndex;
            else if (nums[midIndex] > target) endIndex = midIndex - 1;
            else startIndex = midIndex + 1;
        }

        return startIndex;
    }

    /**
     * Given an array of Strings, find the last unique word in the array.
     *
     * @param words array of Strings
     * @return last unique word
     */
    public static String findLastUniqueWord(String[] words) {
        Set<String> wordsSet = new HashSet<>();
        Set<String> duplicateSet = new HashSet<>();

        // find all duplicate words
        for (String word : words) {
            if (wordsSet.contains(word)) {
                duplicateSet.add(word);
            } else {
                wordsSet.add(word);
            }
        }

        // remove all duplicates from wordsSet
        wordsSet.removeAll(duplicateSet);

        // find last unique word
        String lastUniqueWord = "";
        for (int i = words.length - 1; i >= 0; i--) {
            if (wordsSet.contains(words[i])) {
                lastUniqueWord = words[i];
                break;
            }
        }

        return lastUniqueWord;
    }

    /**
     * Given two arrays of Strings, find all words in first array which have anagram in second array.
     *
     * @param words  array of Strings
     * @param words2 array of Strings
     * @return list of anagrams
     */
    public static List<String> anagramProblem(String[] words, String[] words2) {
        // collect all sorted words into sortedWordSet2
        Set<String> sortedWordSet2 = new HashSet<>();
        for (String word : words2) {
            String sortedCharacters = sortCharacters(word);
            sortedWordSet2.add(sortedCharacters);
        }

        // find all anagrams and collect them into retList
        List<String> retList = new ArrayList<>();
        Set<String> anagramMatched = new HashSet<>();
        for (String word : words) {
            if (sortedWordSet2.contains(sortCharacters(word))) {
                if (!anagramMatched.contains(word)) {
                    anagramMatched.add(word);
                    retList.add(word);
                }
            }
        }

        return retList;
    }

    // Method to return a unique character signature for each string.
    static String sortCharacters(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }


    /**
     * Given two arrays of Strings, find the sum of lengths of all words in second array which have an anagram in first array.
     *
     * @param array1 array of Strings
     * @param array2 array of Strings
     * @return sum of lengths of all words in second array which have an anagram in first array
     */
    public static int findAnagrams(String[] array1, String[] array2) {
        Set<String> sortedWordsInArray1 = new HashSet<>();
        for (String word : array1) {
            sortedWordsInArray1.add(sortCharacters(word));
        }

        int lengthSum = 0;
        Set<String> anagramsMatched = new HashSet<>();
        for (String word : array2) {
            final boolean isAnagram = sortedWordsInArray1.contains(sortCharacters(word));
            final boolean isNotDuplicate = !anagramsMatched.contains(word);
            if (isAnagram && isNotDuplicate) {
                anagramsMatched.add(word);
                lengthSum += word.length();
            }
        }

        return lengthSum;
    }

    /**
     * Given an array of Strings, find the number of majority element otherwise return -1.
     *
     * @param words array of Strings
     * @return number of majority element or -1 if there is no majority element
     */
    static int getMajorityElement(String[] words) {
        int halfListSize = words.length / 2;
        Map<String, Integer> wordsAndCounts = new HashMap<>();

        for (String word : words) {
            final int getWordCount = wordsAndCounts.getOrDefault(word, 0) + 1;
            if (getWordCount > halfListSize) {
                return getWordCount;
            }
            wordsAndCounts.put(word, getWordCount);
        }

        return -1;
    }

    //Binary search recursive
    static int binarySearch(int[] arr, int startIndex, int endIndex, int target) {
        if (startIndex > endIndex) return -1;

        int mid = startIndex + (endIndex - startIndex) / 2;

        if (arr[mid] == target) return mid;

        if (arr[mid] < target)
            return binarySearch(arr, mid + 1, endIndex, target);
        else
            return binarySearch(arr, startIndex, mid - 1, target);

    }

    //Binary search non-recursive
    static int binarySearchNonRecursive(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (end >= start) {
            int mid = start + ((end - start) / 2);

            if (arr[mid] == target) return mid;

            if (arr[mid] < target) start = mid + 1;

            else end = mid - 1;
        }

        return -1;
    }

    // Find the peak index from the array
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

    // Find the maximum value from the rotated array
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

    //Find the missing number in the array
    public static int missingNumber(int[] nums) {
        final int length = nums.length;
        final int sum = Arrays.stream(nums).sum();
        final int expSum = (length * (length + 1)) / 2;

        return expSum - sum;
    }

    //Find the missing number in the array with the best solution
    static int[] twoSumSecondSol(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            final int probableNumber = target - nums[i];
            if (map.containsKey(probableNumber)) {
                return new int[]{map.get(probableNumber), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{0, 0};
    }

    // Find the missing number in the array with boolean array
    static int missingNumberBool(int[] nums) {
        int n = nums.length;
        boolean[] v = new boolean[n + 1];

        for (int num : nums) v[num] = true;
        for (int i = 0; i < v.length; i++) if (!v[i]) return i;

        return 0;
    }

    // Trap the rain water problem
    // Given n non-negative integers representing an elevation map where the width of each bar is 1,
    // compute how much water it can trap after raining.
    static int trap(int[] arr) {
        int startInd = 0;
        int endInd = arr.length - 1;
        int leftMax = arr[startInd];
        int rightMax = arr[endInd];
        int water = 0;

        while (startInd < endInd) {
            if (leftMax < rightMax) {
                startInd++;
                leftMax = Math.max(leftMax, arr[startInd]);
                water += leftMax - arr[startInd];
            } else {
                endInd--;
                rightMax = Math.max(rightMax, arr[endInd]);
                water += rightMax - arr[endInd];
            }
        }

        return water;
    }

    // Find the top k frequent elements in the array
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numberAndCounts = new HashMap<>();

        for (int i : nums)
            numberAndCounts.put(i, numberAndCounts.getOrDefault(i, 0) + 1);

        List<int[]> keyValues = new ArrayList<>();

        numberAndCounts.forEach((integer, integer2) -> keyValues.add(new int[]{integer2, integer}));

        keyValues.sort(Comparator.comparingInt((int[] a) -> a[0]).reversed());

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = keyValues.get(i)[1];
        }

        return res;
    }

    // Find the top k frequent elements in the array with bucket sort, best solution O(n)
    public static int[] topKFrequentBucketSort(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new ArrayList[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = nums.length - 1; index < k && i > 0; i--) {
            for (int n : freq[i]) {
                res[index++] = n;
                if (index == k) return res;
            }
        }

        return res;
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        int s = 1;
        for (int i = 0; i < nums.length; i++) {
            s *= nums[i];

            prefix[i] = s;
        }

        s = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            s *= nums[i];

            suffix[i] = s;
        }

        for (int i = 0; i < n; i++) {
            output[i] = (i - 1 < 0 ? 1 : prefix[i - 1]) * (i + 1 >= n ? 1 : suffix[i + 1]);
        }

        return output;
    }


    public static int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();

        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && m.get(s.charAt(i)) < m.get(s.charAt(i + 1))) {
                ans -= m.get(s.charAt(i));
            } else {
                ans += m.get(s.charAt(i));
            }
        }

        return ans;
    }

    static public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < values.length; i++) {

            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));

        System.out.println(intToRoman(1994));
    }
}
