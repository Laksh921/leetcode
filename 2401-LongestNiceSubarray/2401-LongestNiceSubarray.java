class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int bitmask = 0;
        int maxLen = 0;
        int l = 0;
        for(int r=0;r<n; r++){
            while((bitmask & nums[r]) != 0){
                bitmask ^= nums[l];
                l++;
            }
            bitmask |= nums[r];
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
}