class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        
        int target = total - x;
        
        if (target < 0) {
            return -1;
        }
        if (target == 0) {
            return nums.length;
        }
        
        int n = nums.length;
        int left = 0;
        int currSum = 0;
        int maxLen = -1;
        
        for (int right = 0; right < n; right++) {
            currSum += nums[right];
            
            // shrink window while sum exceeds target
            while (currSum > target && left <= right) {
                currSum -= nums[left];
                left++;
            }
            
            if (currSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        
        return maxLen != -1 ? n - maxLen : -1;
    }
}