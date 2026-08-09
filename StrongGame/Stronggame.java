class Stronggame {

    int n;
    int[] suffix;
    int[][] dp;

    public int stoneGameII(int[] piles) {

        n = piles.length;

        // Suffix Sum
        suffix = new int[n];
        suffix[n - 1] = piles[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        // DP
        dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }

        return dfs(0, 1);
    }

    private int dfs(int i, int M) {

        // Can take all remaining stones
        if (i + 2 * M >= n) {
            return suffix[i];
        }

        // Already calculated
        if (dp[i][M] != -1) {
            return dp[i][M];
        }

        int maxStones = 0;

        // Try taking X piles
        for (int X = 1; X <= 2 * M; X++) {

            int current = suffix[i]
                    - dfs(i + X, Math.max(M, X));

            maxStones = Math.max(maxStones, current);
        }

        return dp[i][M] = maxStones;
    }
}