import java.util.*;

class Solution {
    private int m;
    private int[] cnt;
    private long[] sm;
    private int qc;      // result of query(): count
    private long qs;     // result of query(): sum

    private void update(int i, int dc, long ds) {
        for (; i <= m; i += i & -i) {
            cnt[i] += dc;
            sm[i] += ds;
        }
    }

    private void query(int i) {
        qc = 0;
        qs = 0;
        for (; i > 0; i -= i & -i) {
            qc += cnt[i];
            qs += sm[i];
        }
    }

    // 1-based compressed index of the kk-th smallest element
    private int kth(int kk, int log) {
        int pos = 0;
        for (int p = log; p >= 0; p--) {
            int nxt = pos + (1 << p);
            if (nxt <= m && cnt[nxt] < kk) {
                pos = nxt;
                kk -= cnt[nxt];
            }
        }
        return pos + 1;
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        // coordinate compression
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int[] vals = new int[n];
        m = 0;
        for (int v : sorted) {
            if (m == 0 || vals[m - 1] != v) vals[m++] = v;
        }
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = Arrays.binarySearch(vals, 0, m, nums[i]) + 1;
        }

        cnt = new int[m + 1];
        sm = new long[m + 1];
        int log = 32 - Integer.numberOfLeadingZeros(m);

        // cost of every window of size x
        long[] cost = new long[n - x + 1];
        long total = 0;
        for (int i = 0; i < n; i++) {
            update(rank[i], 1, nums[i]);
            total += nums[i];
            if (i >= x) {
                update(rank[i - x], -1, -(long) nums[i - x]);
                total -= nums[i - x];
            }
            if (i >= x - 1) {
                int medRank = kth((x + 1) / 2, log);
                long med = vals[medRank - 1];
                query(medRank);
                long cLe = qc, sLe = qs;
                cost[i - x + 1] = (med * cLe - sLe)
                                + ((total - sLe) - med * (x - cLe));
            }
        }

        // dp over k non-overlapping windows
        final long INF = Long.MAX_VALUE / 4;
        long[] prev = new long[n + 1];   // 0 windows needed: cost 0
        for (int j = 1; j <= k; j++) {
            long[] cur = new long[n + 1];
            Arrays.fill(cur, INF);
            for (int i = x; i <= n; i++) {
                long a = cur[i - 1];
                long b = prev[i - x] + cost[i - x];
                cur[i] = Math.min(a, b);
            }
            prev = cur;
        }
        return prev[n];
    }
}
