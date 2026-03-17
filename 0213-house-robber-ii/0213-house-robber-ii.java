class Solution {
    int solve(int i, int[] nums, int[] dp){
        if(i >= nums.length){
            return 0;
        }
        if(dp[i] != -1)
            return dp[i];        
        int pick = nums[i] + solve(i+2, nums, dp);
        int notPick = solve(i+1, nums, dp);
        return dp[i] = Math.max(pick, notPick);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] temp1 = new int[n-1];
        int[] temp2 = new int[n-1];
        for(int i = 0; i < n-1; i++){
            temp1[i] = nums[i];
            temp2[i] = nums[i+1];
        }
        int[] dp1 = new int[n-1];
        int[] dp2 = new int[n-1];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.max(solve(0, temp1, dp1), solve(0, temp2, dp2));
    }
}