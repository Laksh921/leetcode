class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n=colors.length;
        int result = 0;
        int valid = 0;
        for(int i=0; i<k-1; i++){
            if(colors[i] != colors[i+1]){
                valid++;
            }
        }
        if(valid == k-1){
            result++;
        }
        for(int i=1; i<n; i++){
            if(colors[(i-1)%n] != colors[(i)%n]){
                valid--;
            }
            if(colors[(i+k-2)%n] != colors[(i+k-1)%n]){
                valid++;
            }
            if(valid == k-1){
                result++;
            }
        }
        return result;
    }
}