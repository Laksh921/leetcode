class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minWindowlength = Integer.MAX_VALUE;
        int sum = 0;
        int low=0;
        int high=0;
        for(high = 0; high < nums.length; high++){
            sum += nums[high];
            while(sum >= target){
                minWindowlength = Math.min(minWindowlength, high-low+1);
                sum -= nums[low];
                low++;
            }
        }
        if(minWindowlength == Integer.MAX_VALUE){
            return 0;
        }
        else{
            return minWindowlength;
        }
    }
}