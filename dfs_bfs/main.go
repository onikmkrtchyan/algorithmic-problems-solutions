package main

import (
	"fmt"
)

// Number of Buses to Reach Destination
// https://leetcode.com/problems/bus-routes/
// You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.
// For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
// Time complexity: O(N^2), where N is the number of bus routes
// Space complexity: O(N^2)
func numBusesToDestination(routes [][]int, source int, target int) int {
	if source == target {
		return 0
	}

	// Create mapping from bus stop to list of bus routes that serve it
	stopToBusRoutes := make(map[int][]int)
	for busId, stops := range routes {
		for _, stop := range stops {
			stopToBusRoutes[stop] = append(stopToBusRoutes[stop], busId)
		}
	}

	var busCount int                       // Number of buses taken
	visitedBusRoutes := make(map[int]bool) // Track buses we've already taken
	visitedBusStops := make(map[int]bool)  // Track stops we've already visited
	currentStops := []int{source}          // Stops we're currently at
	nextStops := make([]int, 0)            // Stops we'll visit next

	// BFS traversal
	for len(currentStops) > 0 {
		nextStops = make([]int, 0)

		for _, currentStop := range currentStops {
			if currentStop == target { // if we reach the target return the bus count
				return busCount
			}

			if visitedBusStops[currentStop] {
				continue
			}
			visitedBusStops[currentStop] = true

			// Try all buses that stop at current location
			for _, busID := range stopToBusRoutes[currentStop] { // try all buses that stop at current location
				// Skip buses we've already taken
				if visitedBusRoutes[busID] {
					continue
				}
				visitedBusRoutes[busID] = true

				// Add all stops on this bus route to next level of BFS
				for _, nextStop := range routes[busID] {
					if !visitedBusStops[nextStop] {
						nextStops = append(nextStops, nextStop)
					}
				}

			}

		}

		busCount++
		currentStops = nextStops
	}

	return -1 // Target unreachable
}

// Course Schedule
// https://leetcode.com/problems/course-schedule/
// Time Complexity: O(N + P), where N is the number of courses and P is the number of prerequisites
func courseSchedule(numCourses int, prerequisites [][]int) bool {
	// Map each course to its prerequisites
	graph := make(map[int][]int)
	for i := 0; i < numCourses; i++ {
		graph[i] = []int{}
	}

	for _, prereq := range prerequisites {
		course, prerequisite := prereq[0], prereq[1]
		graph[course] = append(graph[course], prerequisite)
	}

	// Track courses being visited in current DFS path (for cycle detection)
	inCurrentPath := make(map[int]bool)
	// Track courses that have been fully processed
	visited := make(map[int]bool)

	// Depth-first search to detect cycles
	var hasCycle func(int) bool
	hasCycle = func(course int) bool {
		// If we see a course again in the same path, we have a cycle
		if inCurrentPath[course] {
			return true
		}
		// If we've already verified this course has no cycles
		if visited[course] {
			return false
		}

		// Mark course as being visited in current path
		inCurrentPath[course] = true

		// Check all prerequisites for cycles
		for _, prerequisite := range graph[course] {
			if hasCycle(prerequisite) {
				return true
			}
		}

		// Unmark course from current path
		inCurrentPath[course] = false
		// Mark as fully visited
		visited[course] = true
		return false
	}

	// Check each course for cycles
	for course := 0; course < numCourses; course++ {
		if hasCycle(course) {
			return false // Cycle detected, can't finish all courses
		}
	}

	return true
}

func main() {
	fmt.Println(numBusesToDestination([][]int{{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}}, 1, 19))

	fmt.Println(courseSchedule(5, [][]int{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {3, 4}}))
}
