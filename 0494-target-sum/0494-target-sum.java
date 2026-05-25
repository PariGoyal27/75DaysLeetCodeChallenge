class Solution {
    int[][] dp;
    private int solve(int i, int[] nums, int target){
        if(i == nums.length) {
            if(target == 0) return 1;
            return 0;
        }        
        if(dp[i][target] != -1) return dp[i][target];

        int take = 0;
        if(nums[i] <= target){
            take = solve(i + 1, nums, target - nums[i]);
        }
        int notTake = solve(i + 1, nums, target);

        return dp[i][target] = take + notTake;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int num : nums){
            total += num;
        }
        if(total < target || (total - target) % 2 != 0) return 0;

        target = (total - target) / 2;
        // now count subsets with this target sum
        dp = new int[nums.length][target + 1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return solve(0, nums, target);
    }
}
// class Solution {
//     private int solve(int i, int[] nums, int target, int sum){
//         if(i == nums.length) {
//             if(sum == target) return 1;
//             return 0;
//         }        

//         int plus = solve(i + 1, nums, target, sum + nums[i]);
//         int minus = solve(i + 1, nums, target, sum - nums[i]);

//         return plus + minus;
//     }
//     public int findTargetSumWays(int[] nums, int target) {
//         int total = 0;
//         for(int num : nums){
//             total += num;
//         }
//         if(target < -total) return 0;

//         return solve(0, nums, target, 0);
//     }
// }

// class Solution {
//     private int solve(int i, int[] nums, int target){
//         if(i == nums.length) {
//             if(target == 0) return 1;
//             return 0;
//         }        

//         int plus = solve(i + 1, nums, target - nums[i]);
//         int minus = solve(i + 1, nums, target + nums[i]);

//         return plus + minus;
//     }
//     public int findTargetSumWays(int[] nums, int target) {
//         int total = 0;
//         for(int num : nums){
//             total += num;
//         }
//         if(target < -total) return 0;


//         return solve(0, nums, target);
//     }
// }