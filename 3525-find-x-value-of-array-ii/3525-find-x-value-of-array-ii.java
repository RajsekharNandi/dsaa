class Solution {
    int k, size;
    int[][] cnt;   // cnt[node][r]
    int[] prod;    // prod[node]

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        this.k = k;
        size = 1;
        while (size < n) size *= 2;
        cnt = new int[2 * size][];
        prod = new int[2 * size];

        for (int i = 0; i < n; i++) setLeaf(size + i, nums[i]);
        for (int i = size - 1; i >= 1; i--) pull(i);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0], val = queries[i][1], start = queries[i][2], x = queries[i][3];
            update(idx, val);
            int[] resCnt = query(start, n - 1);
            result[i] = resCnt[x];
        }
        return result;
    }

    void setLeaf(int pos, int val) {
        int[] c = new int[k];
        int r = val % k;
        c[r] = 1;
        cnt[pos] = c;
        prod[pos] = r;
    }

    void pull(int i) {
        int L = 2 * i, R = 2 * i + 1;
        if (cnt[L] == null) { cnt[i] = cnt[R]; prod[i] = prod[R]; }
        else if (cnt[R] == null) { cnt[i] = cnt[L]; prod[i] = prod[L]; }
        else {
            int[] merged = merge(cnt[L], prod[L], cnt[R]);
            cnt[i] = merged;
            prod[i] = (prod[L] * prod[R]) % k;
        }
    }

    int[] merge(int[] leftCnt, int leftProd, int[] rightCnt) {
        int[] res = leftCnt.clone();
        for (int x = 0; x < k; x++) {
            int c = rightCnt[x];
            if (c != 0) {
                int y = (leftProd * x) % k;
                res[y] += c;
            }
        }
        return res;
    }

    void update(int pos, int val) {
        pos += size;
        setLeaf(pos, val);
        pos /= 2;
        while (pos >= 1) { pull(pos); pos /= 2; }
    }

    int[] query(int l, int r) {
        l += size; r += size + 1;
        java.util.List<int[]> leftParts = new java.util.ArrayList<>();
        java.util.List<Integer> leftProds = new java.util.ArrayList<>();
        java.util.List<int[]> rightParts = new java.util.ArrayList<>();
        java.util.List<Integer> rightProds = new java.util.ArrayList<>();

        while (l < r) {
            if ((l & 1) == 1) { leftParts.add(cnt[l]); leftProds.add(prod[l]); l++; }
            if ((r & 1) == 1) { r--; rightParts.add(cnt[r]); rightProds.add(prod[r]); }
            l /= 2; r /= 2;
        }

        int[] resCnt = null; int resProd = 1;
        for (int i = 0; i < leftParts.size(); i++) {
            if (resCnt == null) { resCnt = leftParts.get(i); resProd = leftProds.get(i); }
            else { resCnt = merge(resCnt, resProd, leftParts.get(i)); resProd = (resProd * leftProds.get(i)) % k; }
        }
        for (int i = rightParts.size() - 1; i >= 0; i--) {
            if (resCnt == null) { resCnt = rightParts.get(i); resProd = rightProds.get(i); }
            else { resCnt = merge(resCnt, resProd, rightParts.get(i)); resProd = (resProd * rightProds.get(i)) % k; }
        }
        return resCnt;
    }
}