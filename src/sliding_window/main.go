package main

import "fmt"

func main() {
	arr := []int{1, 2, 3, 3, 3, 4, 4}
	fmt.Println(removeDuplicate(arr))
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

//
