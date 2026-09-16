class Solution {
    public int numberOfSets(int n, int k) {
        final int MOD = 1_000_000_007;

        long[][] dp = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1; 
        }

        for (int j = 1; j <= k; j++) {
          
            long[] prefix = new long[n + 1];
            prefix[0] = dp[0][j - 1];
            for (int t = 1; t <= n; t++) {
                prefix[t] = (prefix[t - 1] + dp[t][j - 1]) % MOD;
            }

            for (int i = 1; i <= n; i++) {
               
                long notUsed = dp[i - 1][j];
              
                long used = (prefix[i - 1] - dp[0][j - 1] % MOD + MOD) % MOD;
                dp[i][j] = (notUsed + used) % MOD;
            }
        }

        return (int) (dp[n][k] % MOD);
    }
}