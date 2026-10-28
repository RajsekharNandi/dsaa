class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        final int MAXV = 1024;
        boolean[][] prev = new boolean[n][MAXV];
        for (int i = 0; i < m; i++) {
            boolean[][] cur = new boolean[n][MAXV];
            for (int j = 0; j < n; j++) {
                int v = grid[i][j];
                if (i == 0 && j == 0) {
                    cur[0][v] = true;
                    continue;
                }
                for (int x = 0; x < MAXV; x++) {
                    boolean reach = (i > 0 && prev[j][x]) || (j > 0 && cur[j - 1][x]);
                    if (reach) cur[j][x ^ v] = true;
                }
            }
            prev = cur;
        }
        for (int x = 0; x < MAXV; x++) {
            if (prev[n - 1][x]) return x;
        }
        return -1;
    }
}