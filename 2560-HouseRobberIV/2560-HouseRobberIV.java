class Solution {
    public int minCapability(int[] nums, int k) {
        int left = Integer.MAX_VALUE;
        int right = 0;
        for(int i=0; i<nums.length; i++){
            left = Math.min(left, nums[i]);
            right = Math.max(nums[i], right);
        }
        while(left < right){
            int mid = (left + right)/2;
            if(canRob(nums, k, mid)){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean canRob(int[] nums, int k, int maxAmount){
        int count=0;
        int i=0;
        while(i<nums.length){
            if(nums[i]<=maxAmount){
                count++;
                i = i+2;
            }
            else{
                i++;
            }
        }
        return count >= k;
    }
}