class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++)
            prefix[i] = prefix[i-1] + nums[i];

        for(int i = n-1; i >= 2; i--){
            if(prefix[i] - nums[i] > nums[i])
                return prefix[i];
        }
        return -1;
    }
}