// Last updated: 3/22/2025, 9:21:35 PM
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Set<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new HashSet<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                List<Integer> component = new ArrayList<>();
                dfs(i, adj, visited, component);
                if(isComplete(component, adj)){
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(int i, List<Set<Integer>> adj, boolean[] visited, List<Integer> component){
        visited[i] = true;
        component.add(i);
        for(int neighbour : adj.get(i)){
            if(!visited[neighbour]){
                dfs(neighbour, adj, visited, component);
            }
        }
    }
    private boolean isComplete(List<Integer> component, List<Set<Integer>> adj){
        int size = component.size();
        for(int i=0; i<size; i++){
            for(int j = i+1; j<size; j++){
                if(!adj.get(component.get(i)).contains(component.get(j))){
                    return false;
                }
            }
        }
        return true;
    }
}