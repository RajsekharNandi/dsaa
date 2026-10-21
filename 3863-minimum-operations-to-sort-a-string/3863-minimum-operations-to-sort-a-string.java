class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] a = s.toCharArray();
        char[] t = a.clone();
        java.util.Arrays.sort(t);
        if (java.util.Arrays.equals(a, t)) return 0;
        if (n == 2) return -1;
        if (a[0] == t[0] || a[n - 1] == t[n - 1]) return 1;

        char mn = t[0], mx = t[n - 1];
        boolean minInPrefix = false, maxInSuffix = false;
        for (int i = 0; i < n - 1; i++) if (a[i] == mn) { minInPrefix = true; break; }
        for (int i = 1; i < n; i++) if (a[i] == mx) { maxInSuffix = true; break; }

        return (minInPrefix || maxInSuffix) ? 2 : 3;
    }
}