class Solution {
    public long countBadPairs(int[] nums) {
        long count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i<nums.length; i++){
            int diff = i - nums[i];
            int gp = map.getOrDefault(diff , 0);
            count = count + i - gp;
            map.put(diff, gp + 1);
        }
        return count;
    }
}