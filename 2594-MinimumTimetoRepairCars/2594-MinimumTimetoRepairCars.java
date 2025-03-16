class Solution {
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);
        long left = 1;
        long right = (long) ranks[0] * cars * cars;
        while(left<right){
            long mid = left + (right - left)/2;
            if(canRepairAllCars(ranks, cars, mid)){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
    private boolean canRepairAllCars(int[] ranks, int cars, long k){
        int repairedCars = 0;
        for(int rank : ranks){
            int maxCars = (int) Math.sqrt(k/rank);
            repairedCars += maxCars;
            if(repairedCars >= cars){
                return true;
            }
        }
        return false;
    }
}