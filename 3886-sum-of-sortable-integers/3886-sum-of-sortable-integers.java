class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int total = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;

            boolean ok = true;
            int prevMax = 0; // nums[i] >= 1, so 0 is a safe start

            for (int s = 0; s < n && ok; s += k) {
                int descents = 0;
                int lo = nums[s], hi = nums[s];

                for (int i = 0; i < k; i++) {
                    int a = nums[s + i];
                    int b = nums[s + (i + 1) % k];
                    if (a > b) {
                        descents++;
                        if (descents > 1) break;
                        hi = a; // max at the drop
                        lo = b; // min right after it
                    }
                }

                if (descents > 1 || lo < prevMax) {
                    ok = false;
                } else {
                    prevMax = hi;
                }
            }

            if (ok) total += k;
        }

        return total;
    }
}