class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int closedIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        // Eliminate land connected to the border
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if ((r == 0 || r == rows - 1 || c == 0 || c == cols - 1) && grid[r][c] == 0) {
                    fill(grid, r, c);
                }
            }
        }

        // Count the remaining islands
        int count = 0;
        for (int r = 1; r < rows - 1; r++) {
            for (int c = 1; c < cols - 1; c++) {
                if (grid[r][c] == 0) {
                    count++;
                    fill(grid, r, c);
                }
            }
        }
        return count;
    }

    private void fill(int[][] grid, int r, int c) {
        int rows = grid.length, cols = grid[0].length;
        Deque<int[]> stack = new ArrayDeque<>();
        grid[r][c] = 1;
        stack.push(new int[]{r, c});

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            for (int[] d : DIRS) {
                int nx = cur[0] + d[0], ny = cur[1] + d[1];
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == 0) {
                    grid[nx][ny] = 1;
                    stack.push(new int[]{nx, ny});
                }
            }
        }
    }
}