class Solution {
    Boolean[][] dp;
    private boolean solve(int[] nums, int ind, int target){
        if(target == 0) return true;
        if(ind == nums.length) return false;
        if(target < 0) return false;

        if(dp[ind][target] != null) return dp[ind][target];

        return dp[ind][target] = solve(nums, ind + 1, target - nums[ind]) || solve(nums, ind + 1, target);
    }
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int i = 0; i < nums.length; i++){
            total += nums[i];
        }
        if(total % 2 != 0) return false;
        dp = new Boolean[nums.length][total / 2 + 1];

        return solve(nums, 0, total/2);
    }
}