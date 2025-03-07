class Solution {
    public boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2; i*i <= n; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
    public int[] closestPrimes(int left, int right) {
        List<Integer> Prime = new ArrayList<>();
        for(int i=left; i<= right; i++){
            if(isPrime(i)){
                Prime.add(i);
            }
        }
        if (Prime.size() < 2){
            return new int[]{-1,-1};
        }
        int minValue = Integer.MAX_VALUE;
        int[] result = new int[2];
        for(int i=1; i<Prime.size(); i++){
            int gap = Prime.get(i) - Prime.get(i-1);
            if(gap < minValue){
                minValue = gap;
                result[0] = Prime.get(i-1);
                result[1] = Prime.get(i);
            }
        }
        return result;
    }
}