class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if(nums.length==0){
            return 0;
        }
        int length=0;
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            if(!map.containsKey(num)){
                int left = map.getOrDefault(num-1,0);
                int right = map.getOrDefault(num+1,0);
                int streak = left + 1 + right;
                length = Math.max(length, streak);
                map.put(num, streak);
                map.put(num-left, streak);
                map.put(num+right, streak);
            }
        }
        return length;
    }
}