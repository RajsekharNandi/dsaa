import java.util.*;

class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> intervals.get(a).get(1) - intervals.get(b).get(1));

        int[] L = new int[n], R = new int[n], W = new int[n], origIdx = new int[n];
        for (int i = 0; i < n; i++) {
            List<Integer> iv = intervals.get(order[i]);
            L[i] = iv.get(0);
            R[i] = iv.get(1);
            W[i] = iv.get(2);
            origIdx[i] = order[i];
        }

       
        long[][] score = new long[n + 1][5];
        List<List<int[]>> dpIdx = new ArrayList<>(); 
        List<Integer>[][] idxArr = new List[n + 1][5];
        for (int k = 0; k <= 4; k++) idxArr[0][k] = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int l = L[i - 1], r = R[i - 1], w = W[i - 1], idx = origIdx[i - 1];
            int p = binarySearch(R, i - 1, l); 

            for (int k = 0; k <= 4; k++) {
                // skip option
                long bestScore = score[i - 1][k];
                List<Integer> bestIdx = idxArr[i - 1][k];

                if (k >= 1) {
                    long candScore = score[p][k - 1] + w;
                    List<Integer> candIdx = new ArrayList<>(idxArr[p][k - 1]);
                    candIdx.add(idx);
                    Collections.sort(candIdx);

                    if (candScore > bestScore ||
                        (candScore == bestScore && compareLists(candIdx, bestIdx) < 0)) {
                        bestScore = candScore;
                        bestIdx = candIdx;
                    }
                }
                score[i][k] = bestScore;
                idxArr[i][k] = bestIdx;
            }
        }

        List<Integer> ans = idxArr[n][4];
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) result[i] = ans.get(i);
        return result;
    }

 
    private int binarySearch(int[] R, int end, int l) {
        int lo = 0, hi = end;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (R[mid] < l) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private int compareLists(List<Integer> a, List<Integer> b) {
        int n = Math.min(a.size(), b.size());
        for (int i = 0; i < n; i++) {
            int cmp = Integer.compare(a.get(i), b.get(i));
            if (cmp != 0) return cmp;
        }
        return Integer.compare(a.size(), b.size());
    }
}