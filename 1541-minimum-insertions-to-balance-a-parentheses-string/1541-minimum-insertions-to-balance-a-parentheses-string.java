class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        int need = 0; // right parens still required

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                need += 2;
                if (need % 2 == 1) {   // previous '(' had only one ')'
                    ans++;             // insert a ')' to complete it
                    need--;
                }
            } else {
                need--;
                if (need == -1) {      // unmatched ')'
                    ans++;             // insert a '('
                    need = 1;          // that '(' still needs one more ')'
                }
            }
        }

        return ans + need;
    }
}