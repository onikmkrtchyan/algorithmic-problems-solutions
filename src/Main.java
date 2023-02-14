import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
//        int[] arr = { 1, 5, 7, -1, 5, 8};
        int[] arr1 = {2, 3};
        int[] arr2 = {4, 1};
        String num1 = Arrays.toString(arr1).replace(",", "").replace("[", "").replace("]", "").replace(" ", "");
        String num2 = Arrays.toString(arr2).replace(",", "").replace("[", "").replace("]", "").replace(" ", "");

//        System.out.println(Solution.convert("PAYPALISHIRINGAGAIN", 5));

        System.out.println(lengthOfLongestSubstring("asdfghhjklaabgdfsa"));
//        System.out.println(Solution.multiply(num1, num2));
//        System.out.println("hi");
    }



    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }

    public static int lengthOfLongestUnrepeatableSubstring(String s) {
        int maxSubLength = 0, currentSubLength = 0;

        for (int i = 0; i < s.length(); i++) {

            if (i != s.length() - 1 && s.charAt(i) != s.charAt(i + 1)) {
                currentSubLength++;
            }

            if (i == s.length() - 1 && s.charAt(i - 1) != s.charAt(i)) {
                currentSubLength++;
            }

            if (i == s.length() - 1 || s.charAt(i) == s.charAt(i + 1)) {
                if (currentSubLength > maxSubLength) {
                    if (i == s.length() - 1) {
                        maxSubLength = currentSubLength;
                    }
                    else {
                        maxSubLength = currentSubLength + 1;
                    }
                }
                currentSubLength = 0;
            }

        }

        return maxSubLength;
    }

}
