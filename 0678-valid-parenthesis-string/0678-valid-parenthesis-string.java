class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();

        // Left to right: treat '*' as '('
        int open = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '*') open++;
            else open--;
            if (open < 0) return false;
        }

        // Right to left: treat '*' as ')'
        int close = 0;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')' || c == '*') close++;
            else close--;
            if (close < 0) return false;
        }

        return true;
    }
}