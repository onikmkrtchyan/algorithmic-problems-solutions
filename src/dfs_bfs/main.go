package main

import "fmt"

func numBusesToDestination(routes [][]int, source int, target int) int {
	if source == target {
		return 0
	}

	// make a index to find the bus
	stop2bus := make(map[int][]int, 8)
	for idx, route := range routes {
		for _, stop := range route {
			stop2bus[stop] = append(stop2bus[stop], idx)
		}
	}

	var res int
	busTaken := make(map[int]bool, 64)    // bus we have takend
	stopVisited := make(map[int]bool, 64) // stop visited
	stops, nextStops := []int{source}, make([]int, 0, 128)
	for len(stops) > 0 {
		nextStops = make([]int, 0, 128)
		for _, stop := range stops {
			if stop == target {
				return res
			}
			if stopVisited[stop] {
				continue
			}
			stopVisited[stop] = true

			for _, busOfStop := range stop2bus[stop] {
				// !!! crucial pruning, timeout if we don't have this line
				if busTaken[busOfStop] {
					continue
				}
				busTaken[busOfStop] = true

				for _, stopOfBus := range routes[busOfStop] {
					if stopVisited[stopOfBus] {
						continue
					}
					nextStops = append(nextStops, stopOfBus)
				}
			}
		}
		res += 1
		stops = nextStops
	}

	return -1
}

func main() {

	fmt.Println(numBusesToDestination([][]int{{1, 2, 7}, {3, 6, 7}}, 1, 7))
}
