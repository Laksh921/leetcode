class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        Map<Integer, Long> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int diff = nums[i] - i;
            map.put(diff, map.getOrDefault(diff, 0l) + 1l);
        }

        long totalPairs = 0;

        totalPairs = ((n - 1) * (long) n) / 2;

        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            long currCount = entry.getValue();

            long currGoodPairs = ((currCount - 1) * (currCount)) / 2;
            totalPairs -= currGoodPairs;
        }

        return totalPairs;
    }
}