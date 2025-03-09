# Algorithms Implementation in Java & Go

This repository contains implementations of various algorithms and data structures in Java and Golang. Each implementation focuses on providing optimal and efficient solutions with clear explanations.

## Sorting Algorithms

### QuickSort (Java)
- **Time Complexity**: O(n log n) average case, O(n²) worst case
- **Space Complexity**: O(log n)
- **Description**: Divide and conquer algorithm that picks an element as pivot and partitions the array around the pivot.

## Tree Algorithms

### Binary Tree Traversals (Go)
- **Pre-order Traversal**: Root → Left → Right
- **In-order Traversal**: Left → Root → Right
- **Post-order Traversal**: Left → Right → Root
- **Description**: Essential tree traversal methods for processing binary tree nodes in different orders.

## Two Pointers Techniques

*Implementation in progress*

## Project Structure

```
.
├── LeetCode/
│   ├── Solution.java
│   └── main.go
├── arrays_hashing/
│   ├── Solution.java
│   └── main.go
├── sorting_algorithms/
│   └── QuickSort.java
├── tree/
│   └── main.go
└── two_pointers/
    └── main.go
```

## Running the Examples

### Java Examples
```bash
javac sorting_algorithms/QuickSort.java
java sorting_algorithms.QuickSort
```

### Go Examples
```bash
go run tree/main.go
```