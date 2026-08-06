class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        int n = nums.length;
        int left = 0;
        long cntPairs = 0;
        long ans = 0;

        for (int right = 0; right < n; right++) {
            int x = nums[right];

            // Add current element
            cntPairs += freq.getOrDefault(x, 0);
            freq.put(x, freq.getOrDefault(x, 0) + 1);

            // Shrink while window is good
            while (cntPairs >= k) {
                ans += (n - right);

                int y = nums[left];
                freq.put(y, freq.get(y) - 1);
                cntPairs -= freq.get(y);
                left++;
            }
        }

        return ans;
    }
}