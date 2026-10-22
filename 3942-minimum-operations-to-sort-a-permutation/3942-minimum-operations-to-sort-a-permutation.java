class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int k = nums[0];

        // Case A: ascending rotation
        boolean asc = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] != (k + i) % n) {
                asc = false;
                break;
            }
        }
        if (asc) {
            ans = (k == 0) ? 0 : Math.min(n - k, k + 2);
        }

        // Case B: descending rotation (needs one reverse)
        boolean desc = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] != ((k - i) % n + n) % n) {
                desc = false;
                break;
            }
        }
        if (desc) {
            int m = (k + 1) % n;
            int cost = (m == 0) ? 1 : Math.min(m + 1, n - m + 1);
            ans = Math.min(ans, cost);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}