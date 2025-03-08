class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        if(n<k){
            return -1;
        }
        int size = 0;
        for(int i=0; i<k; i++){
            if(blocks.charAt(i) == 'W'){
                size++;
            }
        }
        int min = size;
        for(int j = k ; j<n; j++){
            if(blocks.charAt(j) == 'W'){
                size = size + 1;
            }
            if(blocks.charAt(j-k) == 'W'){
                size--;
            }
            min = Math.min(size,min);
        }
        return min;
    }
}