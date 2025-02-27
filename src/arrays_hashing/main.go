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

	return res
}

func main() {
	//arr2 := []int{1, 1, 1, 2, 2, 2, 3}
	arr2 := []int{4, 4, 4, 3, 3, 3, 1, 5, 5}
	result2 := topKFreqElements(arr2, 2)
	fmt.Println(result2)

	encoded := encode([]string{"yes", "You", "are", "doing", "great"})
	println(encoded)

	decoded := decode(encoded)
	println(decoded)
}
