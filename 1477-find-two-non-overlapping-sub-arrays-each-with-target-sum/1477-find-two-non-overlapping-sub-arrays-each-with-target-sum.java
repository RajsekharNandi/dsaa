class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];      
        int ans = Integer.MAX_VALUE;
        int left = 0, sum = 0, minLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left++];
            }

            if (sum == target) {
                int len = right - left + 1;

                if (left > 0 && best[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, len + best[left - 1]);
                }

                minLen = Math.min(minLen, len);
            }

            best[right] = minLen; 
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minSumOfLengths(new int[]{3, 2, 2, 4, 3}, 3));       
        System.out.println(sol.minSumOfLengths(new int[]{7, 3, 4, 7}, 7));          
        System.out.println(sol.minSumOfLengths(new int[]{4, 3, 2, 6, 2, 3, 4}, 6)); 
    }
}