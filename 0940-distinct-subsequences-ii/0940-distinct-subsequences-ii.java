class Solution {
    public int distinctSubseqII(String s) {
        final int MOD = 1_000_000_007;
        long[] last = new long[26];  
        long dpFull = 1;         

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            long oldFull = dpFull;                                
            dpFull = Math.floorMod(2 * dpFull - last[idx], MOD);   
            last[idx] = oldFull;                                    
        }

        return (int) Math.floorMod(dpFull - 1, MOD);  
    }
}