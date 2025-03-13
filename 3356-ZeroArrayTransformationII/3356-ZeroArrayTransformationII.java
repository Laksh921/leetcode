class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int left=0;
        int right = queries.length;
        int ans = -1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(Zeroes(nums.clone(),queries,mid)){
                ans = mid;
                right = mid-1;
            }
            else{
                left = mid + 1;
            }
        }
        return ans;
    }
    private boolean Zeroes(int[] nums, int[][] queries, int k){
        int n = nums.length;
        int[] diff = new int[n+1];
        for(int i=0;i<k;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];
            diff[l] -= val;
            if(r+1<n){
                diff[r+1] += val;
            }
        }
        int curr = 0;
        for(int i=0; i<n; i++){
            curr += diff[i];
            nums[i] = Math.max(0, nums[i] + curr);
        }
        return isZero(nums);
    }
    private boolean isZero(int[] nums){
        for(int num:nums){
            if(num>0){
                return false;
            }
        }
        return true;
    }
}