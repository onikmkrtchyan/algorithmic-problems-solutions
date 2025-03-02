package main

import (
	"fmt"
)

func binarySearch(arr []int, target int) int {
	l := 0
	r := len(arr) - 1

	for l <= r {
		mid := l + (r-l)/2
		if arr[mid] == target {
			return mid
		} else if arr[mid] < target {
			l = mid + 1
		} else {
			r = mid - 1
		}
	}

	return -1
}

func binarySearchRecursive(arr []int, target, l, r int) int {
	if l > r {
		return -1
	}

	mid := l + (r-l)/2

	if arr[mid] == target {
		return mid
	} else if arr[mid] < target {
		return binarySearchRecursive(arr, target, mid+1, r)
	} else {
		return binarySearchRecursive(arr, target, l, mid-1)
	}
}

// Find Minimum in Rotated Sorted Array
func findMin(arr []int) int {
	l := 0
	r := len(arr) - 1

	// array is not rotated(sorted) or has only one element
	if len(arr) == 1 || arr[l] <= arr[r] {
		return arr[l]
	}

	for l < r {
		mid := l + (r-l)/2

		if arr[mid] > arr[r] {
			l = mid + 1
		} else {
			r = mid
		}
	}

	return arr[l]
}

func main() {
	fmt.Println(binarySearch([]int{1, 2, 3, 4, 5}, 3))
	fmt.Println(binarySearchRecursive([]int{1, 2, 3, 4, 5}, 3, 0, 4))

	fmt.Println(findMin([]int{3, 4, 5, 1, 2}))
}
