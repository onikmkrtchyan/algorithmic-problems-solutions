package main

import (
	"fmt"
)

func removeDuplicate(arr []int) []int {
	seen := make(map[int]bool)
	res := make([]int, 0)

	for _, v := range arr {
		if seen[v] == false {
			seen[v] = true
			res = append(res, v)
		}
	}

	return res
}

// Permutation in String
func checkInclusion(s1 string, s2 string) bool {
	lenS1 := len(s1)
	lenS2 := len(s2)
	if lenS1 > lenS2 {
		return false
	}

	arr := make([]int, 26)
	for i := 0; i < lenS1; i++ {
		arr[s1[i]-'a']++
	}
	s1Str := fmt.Sprintf("%v", arr)
	arr = make([]int, 26)

	for i := 0; i < lenS2; i++ {

		arr[s2[i]-'a']++

		if i >= lenS1 {
			arr[s2[i-lenS1]-'a']--
		}

		if s1Str == fmt.Sprintf("%v", arr) {
			return true
		}
	}

	return false
}

// Best Time to Buy and Sell Stock
func maxProfit(prices []int) int {
	left := 0
	right := 1
	maxProfit := 0
	for right < len(prices) {
		if prices[left] > prices[right] {
			left = right
		} else {
			maxProfit = max(maxProfit, prices[right]-prices[left])
		}
		right++
	}

	return maxProfit
}

// Trapping Rain Water
func trappingWater(heights []int) int {
	totalWater := 0
	left := 0
	right := len(heights) - 1
	leftMaxHeight := heights[left]
	rightMaxHeight := heights[right]

	for left < right {
		if leftMaxHeight < rightMaxHeight {
			left++
			leftMaxHeight = max(leftMaxHeight, heights[left])
			totalWater += leftMaxHeight - heights[left]
		} else {
			right--
			rightMaxHeight = max(rightMaxHeight, heights[right])
			totalWater += rightMaxHeight - heights[right]
		}
	}

	return totalWater
}

// Find the maximum number of vowels in a substring of length k
// Time Complexity: O(n)
// Space Complexity: O(1)
func maxVowels(s string, k int) int {
	maxCount := 0
	currentVowelCount := 0
	windowStart := 0

	for windowEnd := 0; windowEnd < len(s); windowEnd++ {
		// Add the current character to our window
		if isVowel(s[windowEnd]) {
			currentVowelCount++
		}

		// If window exceeds size k, shrink from left
		if windowEnd-windowStart+1 > k {
			if isVowel(s[windowStart]) {
				currentVowelCount--
			}
			windowStart++
		}

		// Update maximum vowel count
		maxCount = max(maxCount, currentVowelCount)
	}

	return maxCount
}

func isVowel(c byte) bool {
	return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
}

// Longest Substring Without Repeating Characters
// Complexity O(n) time and O(m) space, where n is the length of the string and m is the number of unique characters in the string.
func lengthOfLongestSubstring(s string) int {
	//todo implement
	return 0
}

func main() {
	arr := []int{1, 2, 3, 3, 3, 4, 4}
	fmt.Println(removeDuplicate(arr)) // answer : [1 2 3 4]

	fmt.Println(checkInclusion("abc", "lecabee"))   // answer : true
	fmt.Println(maxProfit([]int{7, 1, 5, 3, 6, 4})) // answer : 5

	fmt.Println(trappingWater([]int{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})) // answer : 6

	fmt.Println(maxVowels("abciiidef", 3)) // answer : 3
}
