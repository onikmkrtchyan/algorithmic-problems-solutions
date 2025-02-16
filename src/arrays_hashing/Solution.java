package arrays_hashing;

import java.util.*;

class Solution {

    // Medium
    // Group anagrams together in a list of lists
    // Time Complexity: O(n * k) where n is the number of strings and k is the length of the longest string
    // Space Complexity: O(n * k)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);

            if (res.get(key) == null){
                res.put(key, new ArrayList<>());
            }

            res.get(key).add(s);
        }

        return new ArrayList<>(res.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"eat", "ate", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);
        System.out.println(result);
    }
}
