class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] preq : prerequisites){
            adjList.get(preq[1]).add(preq[0]);
        }
        int visited[] = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            if(cyclicC(i, adjList, visited)){
            return false;
            }
        }
        return true;
    }
    private boolean cyclicC(int course,List<List<Integer>> adjList, int[] visited){
        if(visited[course]==1){
            return true;
        }
        if(visited[course] == 2){
            return false;
        }
        visited[course] = 1;
        for(int neighbour : adjList.get(course)){
            if(cyclicC(neighbour, adjList, visited)){
                return true;
            }
        }
        visited[course] = 2;
        return false;
    }
}