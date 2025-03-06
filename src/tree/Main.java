package tree;

public class Main {
    public static class TreeNode {
        char data;
        TreeNode left;
        TreeNode right;

        public TreeNode(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode('R');
        TreeNode nodeA = new TreeNode('A');
        TreeNode nodeB = new TreeNode('B');
        TreeNode nodeC = new TreeNode('C');
        TreeNode nodeD = new TreeNode('D');
        TreeNode nodeE = new TreeNode('E');
        TreeNode nodeF = new TreeNode('F');
        TreeNode nodeG = new TreeNode('G');


        root.left = nodeA;              //    R
//                                         A     B
        root.right = nodeB;

        nodeA.left = nodeC;
        nodeA.right = nodeD;
                                   // C    D
        nodeB.left = nodeE;
        nodeB.right = nodeF;
                                                // E        F
        nodeF.left = nodeG;
                                                      // G
        // Test
        preOrderTraversal(root);
        System.out.println();
        inOrderTraversal(root);
        System.out.println();
        postOrderTraversal(root);
    }

    public static void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }


        preOrderTraversal(node.left);
        System.out.print(node.data + ", ");
        preOrderTraversal(node.right);
    }

    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + ", ");
        inOrderTraversal(node.left);
        inOrderTraversal(node.right);
    }

    public static void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + ", ");
    }
}