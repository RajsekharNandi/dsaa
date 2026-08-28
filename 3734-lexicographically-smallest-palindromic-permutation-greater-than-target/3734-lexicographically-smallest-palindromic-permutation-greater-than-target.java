class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a']++;

        int oddCount = 0;
        char oddChar = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                oddCount++;
                oddChar = (char) ('a' + i);
            }
        }

        char mid = 0;
        boolean hasMid = false;
        if (n % 2 == 0) {
            if (oddCount > 0) return "";
        } else {
            if (oddCount != 1) return "";
            mid = oddChar;
            hasMid = true;
        }

        int h = n / 2;
        int[] Harr = new int[26];
        for (int i = 0; i < 26; i++) Harr[i] = cnt[i] / 2;

        String T1 = target.substring(0, h);

        // ---- Case 1: try exact match of T1 with H ----
        String exact = tryExact(T1, Harr, target, mid, hasMid, h);
        if (exact != null) return exact;

        // ---- Case 2: find smallest A strictly greater than T1 ----
        int[][] prefixStates = new int[h + 1][];
        prefixStates[0] = Harr.clone();
        int[] cur = Harr.clone();
        int maxMatch = 0;
        for (int i = 0; i < h; i++) {
            int idx = T1.charAt(i) - 'a';
            if (cur[idx] > 0) {
                cur[idx]--;
                maxMatch = i + 1;
                prefixStates[maxMatch] = cur.clone();
            } else {
                break;
            }
        }

        int startP = (maxMatch == h) ? maxMatch - 1 : maxMatch;

        for (int p = startP; p >= 0; p--) {
            int[] state = prefixStates[p].clone();
            int tidx = T1.charAt(p) - 'a';
            int found = -1;
            for (int idx = tidx + 1; idx < 26; idx++) {
                if (state[idx] > 0) {
                    found = idx;
                    break;
                }
            }
            if (found == -1) continue;

            state[found]--;

            StringBuilder sb = new StringBuilder();
            sb.append(T1, 0, p);
            sb.append((char) ('a' + found));
            for (int idx = 0; idx < 26; idx++) {
                for (int k = 0; k < state[idx]; k++) {
                    sb.append((char) ('a' + idx));
                }
            }
            String A = sb.toString();

            StringBuilder result = new StringBuilder(A);
            if (hasMid) result.append(mid);
            result.append(new StringBuilder(A).reverse());
            return result.toString();
        }

        return "";
    }

    private String tryExact(String T1, int[] Harr, String target, char mid,
                             boolean hasMid, int h) {
        int[] tcnt = new int[26];
        for (char c : T1.toCharArray()) tcnt[c - 'a']++;
        if (!Arrays.equals(tcnt, Harr)) return null;

        String candidate;
        if (!hasMid) {
            candidate = T1 + new StringBuilder(T1).reverse();
        } else {
            char targetMidChar = target.charAt(h);
            if (mid > targetMidChar) {
                return T1 + mid + new StringBuilder(T1).reverse();
            } else if (mid == targetMidChar) {
                candidate = T1 + mid + new StringBuilder(T1).reverse();
            } else {
                return null;
            }
        }
        return candidate.compareTo(target) > 0 ? candidate : null;
    }
}