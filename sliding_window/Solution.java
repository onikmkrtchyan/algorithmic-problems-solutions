package sliding_window;

class Solution {

    //Easy
    //When to buy and sell stocks to maximize profit
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int maxProfit(int[] prices) {
        int minPriceDay = 0;
        int currentDay = 1;
        int maxProfit = 0;

        while (currentDay < prices.length) {
            if (prices[currentDay] > prices[minPriceDay]) {
                int currentProfit = prices[currentDay] - prices[minPriceDay];
                maxProfit = Math.max(maxProfit, currentProfit);
            } else {
                minPriceDay = currentDay; // Found a new minimum price day
            }

            currentDay++;
        }

        return maxProfit;
    }

    //Medium
    //Find the maximum number of vowels in a substring of length k
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int maxVowels(String s, int k) {
        // Initialize window start, vowel counter and maximum vowels found
        int windowStart = 0;
        int currentVowels = 0;
        int maxVowels = 0;

        // Slide the window by moving the right edge
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            // Add new character to window
            if (isVowel(s.charAt(windowEnd))) {
                currentVowels++;
            }

            // If window size exceeds k, shrink from left
            if (windowEnd - windowStart + 1 > k) {
                if (isVowel(s.charAt(windowStart))) { //  Remove the left character from window
                    currentVowels--;
                }

                windowStart++;
            }

            // Update maximum vowels found so far
            maxVowels = Math.max(currentVowels, maxVowels);
        }

        return maxVowels;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maxProfit(new int[]{10, 1, 5, 1, 6, 7, 1}));

        System.out.println(solution.maxVowels("aeioutest", 3));

    }
}