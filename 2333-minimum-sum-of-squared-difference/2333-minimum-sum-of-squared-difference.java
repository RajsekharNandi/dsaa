class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int mx = 0;
        int[] d = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            d[i] = Math.abs(nums1[i] - nums2[i]);
            mx = Math.max(mx, d[i]);
            sum += d[i];
        }

        long k = (long) k1 + k2;
        if (k >= sum) return 0;

        long[] cnt = new long[mx + 1];
        for (int x : d) cnt[x]++;

        for (int v = mx; v > 0; v--) {
            long c = cnt[v];
            if (c == 0) continue;
            if (c <= k) {
                k -= c;
                cnt[v] = 0;
                cnt[v - 1] += c;
            } else {
                cnt[v] = c - k;
                cnt[v - 1] += k;
                k = 0;
                break;
            }
        }

        long ans = 0;
        for (int v = 0; v <= mx; v++) {
            ans += (long) v * v * cnt[v];
        }
        return ans;
    }
}