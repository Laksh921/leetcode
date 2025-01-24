class Solution {
    private boolean diff(String a, String b){
        int count = 0;
        for(int i=0; i<b.length(); i++){
            if(a.charAt(i) != b.charAt(i)) count++; 
        }
        if(count > 1) return false;
        return count == 1;
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> geneBank = new HashSet<>(Arrays.asList(bank));
        if(!geneBank.contains(endGene)) return -1;
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        Set<String> visited = new HashSet<>();
        visited.add(startGene);
        int mutations = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                String current = queue.poll();
                if(current.equals(endGene)) return mutations;
                for(String gene : geneBank){
                    if(!visited.contains(gene) && diff(current, gene)){
                        queue.add(gene);
                        visited.add(gene);
                    }
                }
            }
            mutations++;
        }
        return -1;
    }
}