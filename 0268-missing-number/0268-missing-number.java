class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int e = (n * (n + 1)) / 2;
        int a = Arrays.stream(nums).sum();
        return e - a;
    }
}
