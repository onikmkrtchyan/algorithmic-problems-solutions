package main

import "fmt"

func main() {
	set := []int{1, 2, 3}
	result := subsets(set)

	fmt.Println("Result ", result)
}

func subsets(set []int) [][]int {
	res := make([][]int, 0)
	current := make([]int, 0, len(set))
	backtracking(&res, current, 0, set)
	return res
}

func backtracking(res *[][]int, current []int, i int, set []int) {
	if i == len(set) {
		subset := make([]int, len(current))
		copy(subset, current) // 1- destination, 2- source
		*res = append(*res, subset)
		return
	}

	current = append(current, set[i])
	backtracking(res, current, i+1, set)

	current = current[:len(current)-1]
	backtracking(res, current, i+1, set)
}
