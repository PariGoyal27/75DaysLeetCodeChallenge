class Solution {
    public long minOperations(int[] nums) {
        int n = nums.length;
        long total = 0;
        for(int i = 1; i < n; i++){
            if(nums[i] < nums[i-1]){
                int diff = nums[i-1] - nums[i];
                total += diff;
            }
        }
        return total;
    }
}