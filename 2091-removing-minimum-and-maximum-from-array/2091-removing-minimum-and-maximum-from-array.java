class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        int maxi = 0;
        int mini = 0;
        for(int i =0; i<n;i++) {
            if(nums[i] > max){
                max = nums[i];
                maxi = i;
            }
            if(nums[i] < min){
                min = nums[i];
                mini = i;
            }
        }

      int left = Math.max(mini,maxi)+1;
      int right = n-Math.min(mini,maxi);
      int both = Math.min(mini,maxi)+1+n -Math.max(mini,maxi);

      return Math.min(left , Math.min(right,both));

    }
}