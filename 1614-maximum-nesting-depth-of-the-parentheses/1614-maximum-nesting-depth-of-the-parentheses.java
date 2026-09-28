class Solution {
    public int maxDepth(String s) {
        int depth = 0, best =0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                depth++;
                best = Math.max(best,depth);
            } else if (ch == ')'){
                depth--;
            }
        }
        return best;
        
    }
}