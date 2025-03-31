// Last updated: 3/31/2025, 11:28:22 PM
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int count=0;
        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                if(nums1[i] == nums2[j] && !contains(result,count,nums1[i])){
                    result[count++] = nums1[i];
                    break;
                }
            }
        }
        return Arrays.copyOf(result,count);
    }
    private boolean contains(int[] result, int count, int value){
        for(int i=0; i<count; i++){
            if(result[i] == value){
                return true;
            }
        }
        return false;
    }
}