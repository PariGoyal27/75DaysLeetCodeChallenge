class Solution {
    Integer[] dp;
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        dp = new Integer[n];

        int diff = solve(0, stoneValue);
        if(diff == 0)
            return "Tie";
        return diff > 0 ? "Alice" : "Bob";
    }
    private int solve(int idx, int[] nums){
        if(idx >= nums.length) return 0;

        if(dp[idx] != null) return dp[idx];

        int take = 0;
        int best = Integer.MIN_VALUE;

        for(int k = 0; k < 3 && idx + k < nums.length; k++){
            take += nums[idx + k];
            best = Math.max(best, take - solve(idx + k + 1, nums));
        }
        return dp[idx] = best;
    }
}