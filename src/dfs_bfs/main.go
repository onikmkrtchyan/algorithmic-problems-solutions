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
func canFinish(numCourses int, prerequisites [][]int) bool {
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

	//fmt.Println(numBusesToDestination([][]int{{1, 2, 7}, {3, 6, 7}}, 1, 7))
	//fmt.Println(numBusesToDestination([][]int{{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}}, 15, 12))
	fmt.Println(numBusesToDestination([][]int{{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}}, 1, 19))

	fmt.Println(canFinish(5, [][]int{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {3, 4}}))
}

// Edge represents a weighted edge
type Edge struct {
	dest   int
	weight int
}

// Graph using an adjacency list
type Graph struct {
	adjList map[int][]Edge // Weighted graph
}

// NewGraph initializes an empty adjacency list
func NewGraph() *Graph {
	return &Graph{adjList: make(map[int][]Edge)}
}

// AddEdge adds a weighted edge (undirected)
func (g *Graph) AddEdge(source, destination, weight int) {
	g.adjList[source] = append(g.adjList[source], Edge{destination, weight})
	g.adjList[destination] = append(g.adjList[destination], Edge{source, weight}) // If undirected
}

// RemoveEdge removes a weighted edge
func (g *Graph) RemoveEdge(source, destination int) {
	g.adjList[source] = removeEdge(g.adjList[source], destination)
	g.adjList[destination] = removeEdge(g.adjList[destination], source)
}

// removeEdge removes an edge from a slice
func removeEdge(edges []Edge, target int) []Edge {
	for i, e := range edges {
		if e.dest == target {
			return append(edges[:i], edges[i+1:]...) // O(degree(v))
		}
	}
	return edges
}

// PrintGraph prints the adjacency list
func (g *Graph) PrintGraph() {
	fmt.Println("Weighted Adjacency List Representation:")
	for vertex, edges := range g.adjList {
		fmt.Printf("%d:", vertex)
		for _, edge := range edges {
			fmt.Printf(" (%d, %d)", edge.dest, edge.weight)
		}
		fmt.Println()
	}
}

//func main() {
//	graph := NewGraph()
//
//	graph.AddEdge(0, 1, 10)
//	graph.AddEdge(0, 2, 6)
//	graph.AddEdge(1, 2, 8)
//	graph.AddEdge(2, 3, 12)
//
//	graph.PrintGraph()
//
//	graph.RemoveEdge(0, 2)
//	fmt.Println("\nAfter Removing Edge (0,2):")
//	graph.PrintGraph()
//}
