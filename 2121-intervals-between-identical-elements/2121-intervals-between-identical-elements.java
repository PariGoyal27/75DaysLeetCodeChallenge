class Solution {
    public long[] getDistances(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];

        Map<Integer, Long> indSum = new HashMap<>(); // Sum to indices
        Map<Integer, Long> indCnt = new HashMap<>(); // Frequency Count

        // Traverse left to right
        for(int i = 0; i < n; i++){
            long freq = indCnt.getOrDefault(nums[i], 0L);
            long sum = indSum.getOrDefault(nums[i], 0L);

            ans[i] += freq * i - sum; // derived formula by observing the pattern
            indCnt.put(nums[i], freq + 1);
            indSum.put(nums[i], sum + i);
        }
        indCnt.clear();
        indSum.clear();
        // Traverse right to left
        for(int i = n-1; i >= 0; i--){
            long freq = indCnt.getOrDefault(nums[i], 0L);
            long sum = indSum.getOrDefault(nums[i], 0L);

            ans[i] += sum - freq * i;
            indCnt.put(nums[i], freq + 1);
            indSum.put(nums[i], sum + i);
        }

        return ans;
    }
}