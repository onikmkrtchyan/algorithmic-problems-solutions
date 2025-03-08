package dfs_bfs;

import java.util.Stack;

public class MatrixPathFinder {

    public static boolean isPathExists(boolean[][] matrix) {
        int n = matrix.length;
        // Create a visited matrix to track visited cells
        boolean[][] visited = new boolean[n][n];

        return dfs(matrix, visited, 0, 0);
    }

    private static boolean dfs(boolean[][] matrix, boolean[][] visited, int x, int y) {
        int n = matrix.length;

        // Base conditions
        // If the cell is out of bounds or blocked or already visited
        if (x < 0 || x >= n || y < 0 || y >= n || !matrix[x][y] || visited[x][y]) {
            return false;
        }

        // If we've reached the bottom-right corner, return true
        if (x == n - 1 && y == n - 1) {
            return true;
        }

        // Mark the current cell as visited
        visited[x][y] = true;

        // Explore all 4 possible directions (down, up, right, left)
        if (dfs(matrix, visited, x + 1, y) ||  // Move down
                dfs(matrix, visited, x - 1, y) ||  // Move up
                dfs(matrix, visited, x, y + 1) ||  // Move right
                dfs(matrix, visited, x, y - 1)) {  // Move left

            return true;
        }

        // Unmark the visited cell (backtrack)
        visited[x][y] = false;

        return false;
    }

    public static boolean isPathExistsIterative(boolean[][] matrix) {
        int n = matrix.length;

        boolean[][] visited = new boolean[n][n];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0});

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int x = current[0];
            int y = current[1];

            // Base conditions
            if (x < 0 || x >= n || y < 0 || y >= n || !matrix[x][y] || visited[x][y]) {
                continue;
            }

            // If we've reached the bottom-right corner, return true
            if (x == n - 1 && y == n - 1) {
                return true;
            }

            // Mark the current cell as visited
            visited[x][y] = true;

            // Push all 4 possible directions (down, up, right, left) onto the stack
            stack.push(new int[]{x + 1, y});  // Move down
            stack.push(new int[]{x - 1, y});  // Move up
            stack.push(new int[]{x, y + 1});  // Move right
            stack.push(new int[]{x, y - 1});  // Move left
        }

        return false;
    }

    public static void main(String[] args) {
        boolean[][] matrix = {
                {true, true, true, true},
                {true, true, false, false},
                {true, true, true, true},
                {true, true, false, true}
        };

//        if (isPathExists(matrix)) {
//            System.out.println("Path exists!");
//        } else {
//            System.out.println("No path exists.");
//        }

        if (isPathExistsIterative(matrix)) {
            System.out.println("Path exists!");
        } else {
            System.out.println("No path exists.");
        }
    }
}
