package main

import (
	"fmt"
)

// TreeNode represents a node in a binary tree
type TreeNode struct {
	data  int
	left  *TreeNode
	right *TreeNode
}

// NewTreeNode creates a new TreeNode with the given data
func NewTreeNode(data int) *TreeNode {
	return &TreeNode{
		data:  data,
		left:  nil,
		right: nil,
	}
}

// PreOrderTraversal performs pre-order traversal on the tree
func PreOrderTraversal(node *TreeNode) {
	if node == nil {
		return
	}

	fmt.Printf("%c, ", node.data)
	PreOrderTraversal(node.left)
	PreOrderTraversal(node.right)
}

// InOrderTraversal performs in-order traversal on the tree
func InOrderTraversal(node *TreeNode) {
	if node == nil {
		return
	}

	InOrderTraversal(node.left)
	fmt.Printf("%c, ", node.data)
	InOrderTraversal(node.right)
}

// PostOrderTraversal performs post-order traversal on the tree
func PostOrderTraversal(node *TreeNode) {
	if node == nil {
		return
	}

	PostOrderTraversal(node.left)
	PostOrderTraversal(node.right)
	fmt.Printf("%c, ", node.data)
}

func main() {
	root := NewTreeNode('R')  //           R
	nodeA := NewTreeNode('A') //       /  \
	nodeB := NewTreeNode('B') //     A     B
	nodeC := NewTreeNode('C') //    / \    / \
	nodeD := NewTreeNode('D') //  C  D  E  F
	nodeE := NewTreeNode('E') //            /
	nodeF := NewTreeNode('F') //           G
	nodeG := NewTreeNode('G')

	root.left = nodeA  //    R
	root.right = nodeB //  A   B

	nodeA.left = nodeC
	nodeA.right = nodeD // C   D

	nodeB.left = nodeE
	nodeB.right = nodeF //     E   F

	nodeF.left = nodeG //        G

	// Test
	PreOrderTraversal(root) // R, A, C, D, B, E, F, G // Root, Left, Right
	fmt.Println()
	InOrderTraversal(root) // C, A, D, R, E, B, G, F // Left, Root, Right
	fmt.Println()
	PostOrderTraversal(root) // C, D, A, E, G, F, B, R // Left, Right, Root
}
