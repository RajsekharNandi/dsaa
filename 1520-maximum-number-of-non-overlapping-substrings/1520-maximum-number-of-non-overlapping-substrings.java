import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] != i) continue; // only build from first occurrence

            int start = i, end = last[c];
            boolean valid = true;
            int j = start;
            while (j <= end) {
                int cj = s.charAt(j) - 'a';
                if (first[cj] < start) {
                    valid = false;
                    break;
                }
                if (last[cj] > end) {
                    end = last[cj];
                }
                j++;
            }

            if (valid) {
                intervals.add(new int[]{start, end});
            }
        }

        // sort by end index
        intervals.sort((a, b) -> a[1] - b[1]);

        List<String> res = new ArrayList<>();
        int lastEnd = -1;
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            if (start > lastEnd) {
                res.add(s.substring(start, end + 1));
                lastEnd = end;
            }
        }

        return res;
    }
}