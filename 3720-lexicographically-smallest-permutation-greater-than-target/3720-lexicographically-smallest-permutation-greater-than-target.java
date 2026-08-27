class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int[] remaining = freq.clone();
        int pivotPos = -1;
        int pivotChar = -1;
        int[] pivotSnapshot = null;

        for (int i = 0; i < n; i++) {
            int x = target.charAt(i) - 'a';

         
            for (int c = x + 1; c < 26; c++) {
                if (remaining[c] > 0) {
                    pivotPos = i;
                    pivotChar = c;
                    pivotSnapshot = remaining.clone();
                    break;
                }
            }

          
            if (remaining[x] > 0) {
                remaining[x]--;
            } else {
                break; 
            }
        }

        if (pivotPos == -1) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(target, 0, pivotPos);
        sb.append((char) ('a' + pivotChar));

        pivotSnapshot[pivotChar]--;
        for (int c = 0; c < 26; c++) {
            for (int k = 0; k < pivotSnapshot[c]; k++) {
                sb.append((char) ('a' + c));
            }
        }

        return sb.toString();
    }
}