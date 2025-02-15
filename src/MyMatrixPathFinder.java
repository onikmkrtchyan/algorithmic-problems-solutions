public class MyMatrixPathFinder {

    public static void main(String[] args) {
        boolean[][] matrix = {
                {true, true, true, true},
                {false, false, true, false},
                {false, true, true, false},
                {true, true, true, true}
        };

        if (isPathExists(matrix)) {
            System.out.println("Path exists!");
        } else {
            System.out.println("No path exists.");
        }
    }


    static boolean isPathExists(boolean[][] matrix) {
        int length = matrix.length;

        boolean[][] visited = new boolean[length][length];

        return findPath(matrix, visited, 0, 0);
    }

    private static boolean findPath(boolean[][] matrix, boolean[][] visited, int x, int y) {
        int n = matrix.length;

        // base
        if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || !matrix[x][y])
            return false;

        // true case
        if (x == n - 1 && y == n - 1) {
            return true;
        }

        visited[x][y] = true;

        if (findPath(matrix, visited, x + 1, y) ||
                findPath(matrix, visited, x - 1, y) ||
                findPath(matrix, visited, x, y - 1) ||
                findPath(matrix, visited, x, y + 1)
        ) {
            return true;
        }

        visited[x][y] = false;

        return false;
    }

}