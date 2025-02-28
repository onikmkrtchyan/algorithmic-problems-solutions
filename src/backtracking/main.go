package main

import (
	"fmt"
	"sort"
)

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

func combinationSum(set []int, target int) [][]int {
	res := make([][]int, 0)
	cur := make([]int, 0, len(set))
	dfs(&res, cur, 0, set, target)
	return res
}

func dfs(res *[][]int, cur []int, i int, set []int, target int) {
	if target == 0 {
		subset := make([]int, len(cur))
		copy(subset, cur)
		*res = append(*res, subset)
		return
	}

	if target < 0 || i >= len(set) {
		return
	}

	cur = append(cur, set[i])
	dfs(res, cur, i, set, target-set[i])

	cur = cur[:len(cur)-1]
	dfs(res, cur, i+1, set, target)
}

func combinationSum2(candidates []int, target int) [][]int {
	res := make([][]int, 0)
	cur := make([]int, 0, len(candidates))
	sort.Ints(candidates)
	dfs2(&res, cur, 0, candidates, target)
	return res
}

func dfs2(res *[][]int, cur []int, i int, set []int, target int) {
	if target == 0 {
		cur2 := make([]int, len(cur))
		copy(cur2, cur)
		*res = append(*res, cur2)
		return
	}

	if i >= len(set) || target < 0 {
		return
	}

	// Early termination: current number is too large
	if set[i] > target {
		return
	}

	// Include current number
	cur = append(cur, set[i])
	dfs2(res, cur, i+1, set, target-set[i])

	cur = cur[:len(cur)-1]

	for i+1 < len(set) && set[i] == set[i+1] {
		i++
	}

	dfs2(res, cur, i+1, set, target)
}

func main() {
	set := []int{1, 2, 3}
	result := subsets(set)
	fmt.Println("Result ", result)

	set2 := []int{2, 3, 6, 7}
	result = combinationSum(set2, 7)
	fmt.Println("Result 2 ", result)

	set3 := []int{10, 1, 2, 7, 6, 1, 5}
	result = combinationSum2(set3, 8)
	fmt.Println(result)
}
