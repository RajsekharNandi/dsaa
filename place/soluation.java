class Solution {
    public int longestSubsequence(int[] nums) {
       c:\\Users\\Rajsekhar Nandi\\OneDrive\\Documents\\Desktop\\das\\place\\soluation.java$0 int xorAll = 0;
        boolean hasNoZero = false;

        
        for (int x : nums) {
            xorAll ^= x;
            if (x != 0) hasNoZero = true;
        }

        if (!hasNoZero) return 0;
        if (xorAll !=0) return nums.length;
        return nums.length - 1;
    }
}
