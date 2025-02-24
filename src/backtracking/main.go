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

// todo not working
func backtracking(res *[][]int, current []int, i int, set []int) {
	if i < len(set) {
		*res = append(*res, current)
		return
	}

	current = append(current, set[i])
	backtracking(res, current, i+1, set)

	current = current[:len(current)-1]
	backtracking(res, current, i+1, set)
}
