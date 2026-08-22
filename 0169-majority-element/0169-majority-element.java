class Solution {
    public int majorityElement(int[] nums) {
    //     Arrays.sort(nums);
    //     return nums[(nums.length/2)];
    // }
    int count = 0;
    int current = nums[0];

    for(int i = 0; i < nums.length; i++)
    {
        if(current == nums[i]){
            count++;
        }
        else {
            count--;
        }
        if(count == -1){
            
            current = nums[i];
            count = 0;
        }
    } 
   return current;
}
}