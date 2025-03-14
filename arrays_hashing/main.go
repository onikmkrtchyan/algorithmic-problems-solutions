package main

import (
	"fmt"
	"strconv"
)

func topKFreqElements(arr []int, k int) []int {
	counts := make(map[int]int)

	// add the number to map or increment the count
	for _, v := range arr {
		counts[v]++
	}

	//This is an array of slices
	bucket := make([][]int, len(arr)+1)
	for key, val := range counts {
		bucket[val] = append(bucket[val], key)
	}

	retArr := make([]int, 0, k)
	for i := len(bucket) - 1; i >= 0; i-- {
		retArr = append(retArr, bucket[i]...)
		if len(retArr) >= k {
			break
		}
	}

	return retArr[:k]
}

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

func containsDuplicate(arr []int) bool {
	// Initialize the map properly
	m := make(map[int]int)

	for _, v := range arr {
		// If the key exists in map, we found a duplicate
		_, ok := m[v]
		if ok {
			return true
		}

		// Add the number to map
		m[v] = 1
	}

	return false
}

func twoSum(nums []int, target int) []int {
	counts := make(map[int]int)

	ret := make([]int, 0, 2)
	for i, v := range nums {
		if val, exists := counts[target-v]; exists {
			ret = append(ret, val, i)
			break
		}

		counts[v] = i
	}

	return ret
}

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	arr := make([]int, 26)
	for i := range s {
		arr[s[i]-'a']++
		arr[t[i]-'a']--
	}

	for _, v := range arr {
		if v != 0 {
			return false
		}
	}

	return true
}

// encode and decode string
func encode(strs []string) string {
	res := ""

	for _, str := range strs {
		res += strconv.Itoa(len(str)) + "#" + str
	}

	return res
}

func decode(str string) []string {
	res := make([]string, 0)

	for i := 0; i < len(str); {
		j := i
		for ; j < len(str) && str[j] != '#'; j++ {
		}

		length, _ := strconv.Atoi(str[i:j])
		res = append(res, str[j+1:j+1+length])
		i = j + 1 + length
	}

	return res
}

// Time complexity: O(n)
// Space Complexity: O(1) excluding the output array
// The result array res doesn't count as extra space since it's the required output
func productExceptSelf(nums []int) []int {
	n := len(nums)

	// Create three arrays
	prefix := make([]int, n)  // Stores products of all elements to the left
	postfix := make([]int, n) // Stores products of all elements to the right
	result := make([]int, n)  // Stores the final result

	// Calculate prefix products [1, 1, 2, 6] for nums = [1, 2, 3, 4]
	prefix[0] = 1 // No elements to the left of first element
	for i := 1; i < n; i++ {
		prefix[i] = prefix[i-1] * nums[i-1]
	}

	// Calculate postfix products [24, 12, 4, 1] for nums = [1, 2, 3, 4]
	postfix[n-1] = 1 // No elements to the right of last element
	for i := n - 2; i >= 0; i-- {
		postfix[i] = postfix[i+1] * nums[i+1]
	}

	// Calculate final result by multiplying prefix and postfix [24, 12, 8, 6]
	for i := 0; i < n; i++ {
		result[i] = prefix[i] * postfix[i]
	}

	return result
}

func isValidSudoku(board [][]byte) bool {
	rows := make([]map[byte]bool, 9)
	cols := make([]map[byte]bool, 9)
	squares := make([]map[byte]bool, 9)

	for i := 0; i < 9; i++ {
		rows[i] = make(map[byte]bool)
		cols[i] = make(map[byte]bool)
		squares[i] = make(map[byte]bool)
	}

	for r := 0; r < 9; r++ {
		for c := 0; c < 9; c++ {
			if board[r][c] == '.' {
				continue
			}

			val := board[r][c]
			squareIdx := (r/3)*3 + c/3

			if rows[r][val] || cols[c][val] || squares[squareIdx][val] {
				return false
			}

			rows[r][val] = true
			cols[c][val] = true
			squares[squareIdx][val] = true
		}
	}

	return true
}

// Each number in the array is visited at most twice (once in the outer loop, and at most once as part of a consecutive sequence in the inner loop)
// Time complexity: O(n)
// Space complexity: O(n)
func longestConsecutive(nums []int) int {
	// Initialize the map
	numsMap := make(map[int]bool)
	for _, v := range nums {
		numsMap[v] = true
	}

	longest := 0
	// If iterate over the map instead of nums slice, the runtime would be 10x faster than slice.
	//for _, v := range nums { // slice can contain duplicates
	for v := range numsMap {
		// If the number is already part of a sequence, skip it till the first number
		if numsMap[v-1] {
			continue
		}

		current := 1
		for numsMap[v+1] {
			current++
			v++
		}

		if current > longest {
			longest = current
		}
	}

	return longest
}

func main() {
	//arr2 := []int{1, 1, 1, 2, 2, 2, 3}
	arr2 := []int{4, 4, 4, 3, 3, 3, 1, 5, 5}
	result2 := topKFreqElements(arr2, 2)
	fmt.Println(result2)

	fmt.Println(productExceptSelf([]int{1, 2, 3, 4}))

	encoded := encode([]string{"yes", "You", "are", "doing", "great"})
	fmt.Println(encoded)

	decoded := decode(encoded)
	fmt.Println(decoded)

	board := [][]byte{
		{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
		{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
		{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
		{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
		{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
		{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
		{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
		{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
		{'.', '.', '.', '.', '8', '.', '.', '7', '9'},
	}

	fmt.Println(isValidSudoku(board))

	fmt.Println("LongestConsecutive ", longestConsecutive([]int{100, 4, 200, 1, 3, 2}))
}
