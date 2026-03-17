class Solution {
    // int solve(int i, int[] nums, int[] dp){
    //     if(i >= nums.length){
    //         return 0;
    //     }
    //     if(dp[i] != -1)
    //         return dp[i];
        
    //     int pick = nums[i] + solve(i+2, nums, dp);
    //     int notPick = solve(i+1, nums, dp);
    //     return dp[i] = Math.max(pick, notPick);
    // }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i < n+1; i++){
            int pick = nums[i-1] + dp[i-2];
            int notPick = dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n];
    }
}