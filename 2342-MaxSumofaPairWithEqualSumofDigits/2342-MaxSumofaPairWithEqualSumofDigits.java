class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int maxSum = -1;
        for(int num : nums){
            int sum = sumOfDigits(num);
            int[] two = map.getOrDefault(sum, new int[]{-1,-1});
            if(num > two[0]){
                two[1] = two[0];
                two[0] = num;
            }
            else if(num > two[1]){
                two[1] = num;
            }
            map.put(sum, two);
        }
        for(int[] pair : map.values()){
            if(pair[1] != -1){
                maxSum = Math.max(maxSum, pair[0] + pair[1]);
            }
        }
        return maxSum;
    }
    public static int sumOfDigits(int num){
        int sum=0;
        while(num > 0){
            sum += num % 10;
            num = num/10;
        }
        return sum;
    }
}