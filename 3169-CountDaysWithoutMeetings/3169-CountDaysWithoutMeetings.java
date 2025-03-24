// Last updated: 3/25/2025, 1:50:51 AM
class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int occupiedDays = 0;
        int start = -1, end = -1;
        for(int[] pair : meetings){
            if(start == -1){
                start = pair[0];
                end = pair[1];
            }
            else if(pair[0] > end){
                occupiedDays += (end - start + 1);
                start = pair[0];
                end = pair[1];
            }
            else{
                end = Math.max(end, pair[1]);
            }
        }
        if(start != -1){
            occupiedDays += (end - start + 1);
        }
        return days - occupiedDays;
    }
}