class Solution {
    public int maximumCandies(int[] candies, long k) {
        long total = 0;
        int low = 1;
        int high = 0;
        for(int i=0;i<candies.length;i++){
            total += candies[i];
            high = Math.max(high,candies[i]);
        }
        if(total<k){
            return 0;
        }
        int result = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(distribution(candies, k, mid)){
                result = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return result;
    }
    private boolean distribution(int[] candies, long k, int perChild){
        if(perChild == 0){
            return false;
        }
        long count = 0;
        for(int c:candies){
            count += c/perChild;
        }
        return count >= k;
    }
}