package main

import "fmt"

/*
The idea is to solve a word puzzle!
The allowed movements are for now horizontal and vertical, no diagonals.

[

	[a,a,w,h,n,s,a],
	[b,c,w,d,g,a,s],
	[c,k,w,d,a,s,a],

]

["ack", "pigeon"]
[True, False] => False

["ack", "gas"]
[True, True] => True

*/
// Time complexity: O(n*m*4^l) where n is the number of rows, m is the number of columns, and l is the length of the word
// Space complexity: O(n*m)
func wordSearch(board [][]byte, word string) bool {
	if len(word) == 0 {
		return true
	}

	for row := range board {
		for col := range board[row] {

			if board[row][col] == word[0] {
				visited := make([][]bool, len(board))
				for i := range visited {
					visited[i] = make([]bool, len(board[0]))
				}

				if dfs(board, row, col, word, 0, visited) {
					return true
				}
			}
		}
	}

	return false
}

func dfs(board [][]byte, row, col int, word string, index int, visited [][]bool) bool {
	// Base cases
	if index == len(word) {
		return true
	}

	// Out of bounds or already visited or character doesn't match
	if row < 0 || row >= len(board) || col < 0 || col >= len(board[0]) ||
		visited[row][col] || board[row][col] != word[index] {
		return false
	}

	// Mark current cell as visited
	visited[row][col] = true

	// Try all four directions
	if dfs(board, row+1, col, word, index+1, visited) ||
		dfs(board, row-1, col, word, index+1, visited) ||
		dfs(board, row, col+1, word, index+1, visited) ||
		dfs(board, row, col-1, word, index+1, visited) {
		return true
	}

	// Backtrack
	visited[row][col] = false

	return false
}

func main() {
	board := [][]byte{
		{'a', 'a', 'w', 'h', 'n', 's', 'a'},
		{'b', 'c', 'w', 'd', 'g', 'a', 's'},
		{'c', 'k', 'w', 'd', 'a', 's', 'a'}}

	fmt.Println(wordSearch(board, "abc"))  // true
	fmt.Println(wordSearch(board, "dasa")) // true
}

///*
//The idea is to solve a word puzzle!
//The allowed movements are for now horizontal and vertical, no diagonals.
//
//[
// [a,a,w,h,n,s,a],
// [b,c,w,d,g,a,s],
// [c,k,w,d,a,s,a],
//]
//
//["ack", "pigeon"]
//[True, False] => False
//
//["ack", "gas"]
//[True, True] => True
//
//
//Further simplification:
//Only horizontal movements
//*/
//
//func containsWord(crossword [][]byte, word string) bool {
//	wordMap := make(map[byte]int)
//	for _, c := range word {
//		wordMap[byte(c)] += 1
//	}
//
//	for row := range crossword {
//		for col := range crossword[row] {
//			if dfs(crossword, row, col, wordMap, len(word)) {
//				return true
//			}
//		}
//	}
//
//	return false
//}
//
//func dfs(crossword [][]byte, row int, column int, word map[byte]int, wordLen int) bool {
//	// First base case here
//	done := true
//	for _, value := range word {
//		if value != 0 {
//			done = false
//			break
//		}
//	}
//	if done {
//		return true
//	}
//
//	if wordLen < 0 {
//		return false
//	}
//
//	if row < 0 || row >= len(crossword) || column < 0 || column >= len(crossword[0]) {
//		return false
//	}
//
//	if _, ok := word[crossword[row][column]]; ok {
//		word[crossword[row][column]] -= 1
//	}
//
//	return dfs(crossword, row+1, column, word, wordLen-1) ||
//		dfs(crossword, row-1, column, word, wordLen-1) ||
//		dfs(crossword, row, column-1, word, wordLen-1) ||
//		dfs(crossword, row, column+1, word, wordLen-1)
//}
