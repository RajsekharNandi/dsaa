class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if (k > n) return 0;

        boolean[][] isPalin = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            isPalin[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i == 1 || isPalin[i + 1][j - 1])) {
                    isPalin[i][j] = true;
                }
            }
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            for (int length = k; length <= k + 1; length++) {
                int j = i - length;
                if (j >= 0 && isPalin[j][i - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    break;
                }
            }
        }

        return dp[n];
    }
}