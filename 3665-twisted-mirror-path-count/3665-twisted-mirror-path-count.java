class Solution {
    public int uniquePaths(int[][] grid) {
        final int MOD = 1_000_000_007;
        int m = grid.length, n = grid[0].length;

        // A[i][j][0]: attempts entering (i,j) while moving right
        // A[i][j][1]: attempts entering (i,j) while moving down
        // Extra row/column of padding absorbs out-of-bounds moves.
        long[][][] A = new long[m + 1][n + 1][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                long r = A[i][j][0];
                long d = A[i][j][1];

                if (grid[i][j] == 0) {
                    long total = (r + d + ((i == 0 && j == 0) ? 1 : 0)) % MOD;
                    if (i == m - 1 && j == n - 1) {
                        return (int) total;
                    }
                    A[i][j + 1][0] = (A[i][j + 1][0] + total) % MOD;
                    A[i + 1][j][1] = (A[i + 1][j][1] + total) % MOD;
                } else {
                    // moving right into a mirror -> reflected down
                    A[i + 1][j][1] = (A[i + 1][j][1] + r) % MOD;
                    // moving down into a mirror -> reflected right
                    A[i][j + 1][0] = (A[i][j + 1][0] + d) % MOD;
                }
            }
        }
        return 0;
    }
}