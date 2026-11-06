import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        int m = queries.length;
        Integer[] order = new Integer[m];
        for (int i = 0; i < m; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> queries[a] - queries[b]);

        int[] count = new int[n + 1];
        int active = 0, left = 0, right = 0;
        int[] ans = new int[m];

        for (int idx : order) {
            int q = queries[idx];

            while (right < logs.length && logs[right][1] <= q) {
                if (count[logs[right][0]]++ == 0) active++;
                right++;
            }

            while (left < right && logs[left][1] < q - x) {
                if (--count[logs[left][0]] == 0) active--;
                left++;
            }

            ans[idx] = n - active;
        }
        return ans;
    }
}