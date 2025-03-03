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

func maxProfit(prices []int) int {
	l := 0
	r := 1
	res := 0
	for r < len(prices) {
		if prices[l] > prices[r] {
			l = r
		} else {
			res = max(res, prices[r]-prices[l])
		}
		r++
	}

	return res
}

func main() {
	arr := []int{1, 2, 3, 3, 3, 4, 4}
	fmt.Println(removeDuplicate(arr))

	fmt.Println(checkInclusion("abc", "lecabee"))
	fmt.Println(maxProfit([]int{7, 1, 5, 3, 6, 4}))
}
