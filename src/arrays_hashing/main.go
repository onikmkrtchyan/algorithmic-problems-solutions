package main

import "fmt"

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

func productExceptSelf(nums []int) []int {
	n := len(nums)
	res := make([]int, n)

	for i := range res {
		res[i] = 1
	}

	prefix := 1
	for i := range n {
		res[i] = prefix
		prefix *= nums[i]
	}

	postfix := 1
	for i := n - 1; i >= 0; i-- {
		res[i] *= postfix
		postfix *= nums[i]
	}

	return res
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

func main() {
	//arr2 := []int{1, 1, 1, 2, 2, 2, 3}
	arr2 := []int{4, 4, 4, 3, 3, 3, 1, 5, 5}
	result2 := topKFreqElements(arr2, 2)
	fmt.Println(result2)

	//print(isAnagram("anagram", "nagaram"))

	//fmt.Print(productExceptSelf([]int{1, 2, 3, 4}))

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

}
