// Last updated: 3/23/2025, 11:16:20 PM
class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] road : roads){
            int u = road[0], v = road[1], time = road[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }
        long[] shortestTime = new long[n];
        int[] ways = new int[n];
        Arrays.fill(shortestTime, Long.MAX_VALUE);
        shortestTime[0] = 0;
        ways[0] = 1;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[]{0,0});
        while(!pq.isEmpty()){
            long[] current = pq.poll();
            long time = current[0];
            int node = (int) current[1];
            if(time > shortestTime[node]) continue;
            for(int[] neighbour : graph.get(node)){
                int nextNode = neighbour[0];
                long newTime = time + neighbour[1];
                if(newTime < shortestTime[nextNode]){
                    shortestTime[nextNode] = newTime;
                    ways[nextNode] = ways[node];
                    pq.add(new long[]{newTime, nextNode});
                }
                else if(newTime == shortestTime[nextNode]){
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                } 
            }
        } 
        return ways[n-1];

    }
}