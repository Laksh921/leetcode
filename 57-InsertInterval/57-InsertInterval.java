class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> result = new ArrayList<>();
        for(int i=0; i<intervals.length; i++){
            int[] current = intervals[i];
            if(current[1] < newInterval[0]){
                result.add(current);
            }
            else if(current[0] > newInterval[1]){
                result.add(newInterval);
                newInterval = current;
            }
            else{
                newInterval[0] = Math.min(newInterval[0], current[0]);
                newInterval[1] = Math.max(newInterval[1], current[1]);
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}