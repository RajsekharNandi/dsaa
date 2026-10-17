class Solution {
    private static final long MOD = 1_000_000_007L;
    private long[] s, sq, lz;

    private void apply(int o, int len, long x) {
        sq[o] = (sq[o] + 2 * x % MOD * s[o] + x * x % MOD * len) % MOD;
        s[o]  = (s[o] + x * len) % MOD;
        lz[o] += x;                      // at most n, no mod needed
    }

    private void push(int o, int l, int r) {
        if (lz[o] != 0) {
            int m = (l + r) >>> 1;
            apply(2 * o,     m - l + 1, lz[o]);
            apply(2 * o + 1, r - m,     lz[o]);
            lz[o] = 0;
        }
    }

    private void update(int o, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            apply(o, r - l + 1, 1);
            return;
        }
        push(o, l, r);
        int m = (l + r) >>> 1;
        if (ql <= m) update(2 * o, l, m, ql, qr);
        if (qr > m)  update(2 * o + 1, m + 1, r, ql, qr);
        s[o]  = (s[2 * o]  + s[2 * o + 1])  % MOD;
        sq[o] = (sq[2 * o] + sq[2 * o + 1]) % MOD;
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        s  = new long[4 * n];
        sq = new long[4 * n];
        lz = new long[4 * n];

        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);

        long ans = 0;
        for (int j = 0; j < n; j++) {
            update(1, 0, n - 1, last[nums[j]] + 1, j);
            last[nums[j]] = j;
            ans = (ans + sq[1]) % MOD;
        }
        return (int) ans;
    }
}