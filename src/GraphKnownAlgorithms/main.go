package main

import (
	"container/heap"
	"fmt"
)

// Edge represents a connection between nodes with a weight
type Edge struct {
	to     int
	weight int
}

// Graph represents a weighted graph using an adjacency list
type Graph struct {
	adjacencyList [][]Edge
}

// NewGraph creates a new graph with n vertices
func NewGraph(n int) *Graph {
	return &Graph{
		adjacencyList: make([][]Edge, n),
	}
}

// AddEdge adds a directed edge from source to destination with given weight
func (g *Graph) AddEdge(from, to, weight int) {
	g.adjacencyList[from] = append(g.adjacencyList[from], Edge{to: to, weight: weight})
}

// AddUndirectedEdge adds an edge in both directions
func (g *Graph) AddUndirectedEdge(from, to, weight int) {
	g.AddEdge(from, to, weight)
	g.AddEdge(to, from, weight)
}

// Item for the priority queue
type Item struct {
	vertex   int
	distance int
	index    int // The index in the heap
}

// PriorityQueue implements heap.Interface
type PriorityQueue []*Item

func (pq PriorityQueue) Len() int           { return len(pq) }
func (pq PriorityQueue) Less(i, j int) bool { return pq[i].distance < pq[j].distance }
func (pq PriorityQueue) Swap(i, j int) {
	pq[i], pq[j] = pq[j], pq[i]
	pq[i].index = i
	pq[j].index = j
}

func (pq *PriorityQueue) Push(x interface{}) {
	n := len(*pq)
	item := x.(*Item)
	item.index = n
	*pq = append(*pq, item)
}

func (pq *PriorityQueue) Pop() interface{} {
	old := *pq
	n := len(old)
	item := old[n-1]
	old[n-1] = nil  // avoid memory leak
	item.index = -1 // for safety
	*pq = old[0 : n-1]
	return item
}

// Dijkstra computes the shortest path from the source to all other vertices
func (g *Graph) Dijkstra(source int) ([]int, []int) {
	numVertices := len(g.adjacencyList)
	distances := make([]int, numVertices)
	previous := make([]int, numVertices)

	// Initialize distances and previous array
	for i := 0; i < numVertices; i++ {
		distances[i] = int(^uint(0) >> 1) // Max int
		previous[i] = -1                  // No previous vertex initially
	}
	distances[source] = 0 // Distance to source is 0

	// Create priority queue with vertices
	pq := make(PriorityQueue, 0)
	heap.Init(&pq)

	// Add source vertex to priority queue
	heap.Push(&pq, &Item{
		vertex:   source,
		distance: 0,
	})

	// Process vertices in priority order
	for pq.Len() > 0 {
		// Get vertex with minimum distance
		current := heap.Pop(&pq).(*Item)
		currentVertex := current.vertex

		// If we've already found a shorter path, skip
		if current.distance > distances[currentVertex] {
			continue
		}

		// Check all neighbors
		for _, edge := range g.adjacencyList[currentVertex] {
			neighborVertex := edge.to

			// Calculate potential new distance
			newDistance := distances[currentVertex] + edge.weight

			// If we found a shorter path
			if newDistance < distances[neighborVertex] {
				distances[neighborVertex] = newDistance
				previous[neighborVertex] = currentVertex

				// Add to priority queue
				heap.Push(&pq, &Item{
					vertex:   neighborVertex,
					distance: newDistance,
				})
			}
		}
	}

	return distances, previous
}

// GetPath reconstructs the path from source to target
func GetPath(source, target int, previous []int) []int {
	path := []int{}

	// If there's no path
	if previous[target] == -1 && source != target {
		return path
	}

	// Reconstruct the path
	for current := target; current != -1; current = previous[current] {
		path = append([]int{current}, path...)
	}

	return path
}

func main() {
	// Create a graph with 6 vertices
	graph := NewGraph(6)

	// Add edges
	graph.AddUndirectedEdge(0, 1, 7)
	graph.AddUndirectedEdge(0, 2, 9)
	graph.AddUndirectedEdge(0, 5, 14)
	graph.AddUndirectedEdge(1, 2, 10)
	graph.AddUndirectedEdge(1, 3, 15)
	graph.AddUndirectedEdge(2, 3, 11)
	graph.AddUndirectedEdge(2, 5, 2)
	graph.AddUndirectedEdge(3, 4, 6)
	graph.AddUndirectedEdge(4, 5, 9)

	// Run Dijkstra's algorithm from vertex 0
	source := 0
	distances, previous := graph.Dijkstra(source)

	// Print the shortest distances
	fmt.Printf("Shortest distances from vertex %d:\n", source)
	for vertex, distance := range distances {
		fmt.Printf("To vertex %d: %d\n", vertex, distance)

		// Print the path
		path := GetPath(source, vertex, previous)
		fmt.Printf("Path: %v\n\n", path)
	}
}
