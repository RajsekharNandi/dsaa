import java.util.*;

class stonegamev {
    private int[] prefix;
    private Integer[][] memo;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        memo = new Integer[n][n];
        return dp(0, n - 1);
    }

    private int rangeSum(int i, int j) {
        return prefix[j + 1] - prefix[i];
    }

    private int dp(int i, int j) {
        if (i == j) return 0;
        if (memo[i][j] != null) return memo[i][j];

        int best = 0;
        for (int k = i; k < j; k++) {
            int left = rangeSum(i, k);
            int right = rangeSum(k + 1, j);

            if (left <= right) {
                best = Math.max(best, dp(i, k) + left);
            }
            if (right <= left) {
                best = Math.max(best, dp(k + 1, j) + right);
            }
        }

        memo[i][j] = best;
        return best;
    }
}