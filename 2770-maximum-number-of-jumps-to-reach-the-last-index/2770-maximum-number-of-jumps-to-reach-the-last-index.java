// recursion + memoization
class Solution {
    int[] dp;
    private int solve(int idx, int[] nums, int target){
        if(idx == nums.length-1){
            return dp[idx] = 0;
        }
        if(dp[idx] != Integer.MIN_VALUE) return dp[idx];
        int maxJumps = Integer.MIN_VALUE;
        for(int i = idx + 1; i < nums.length; i++){
            if(Math.abs(nums[i] - nums[idx]) <= target){
                int jump = solve(i, nums, target);
                maxJumps = Math.max(1 + jump, maxJumps);
            }
        }
        return dp[idx] = maxJumps;
    }
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int res = solve(0, nums, target);
        return res < 0 ? -1 : res;
    }
}
// recursion - TLE
// class Solution {
//     private int solve(int idx, int[] nums, int target){
//         if(idx == nums.length-1){
//             return 0;
//         }
//         int maxJumps = Integer.MIN_VALUE;
//         for(int i = idx + 1; i < nums.length; i++){
//             if(Math.abs(nums[i] - nums[idx]) <= target){
//                 int jump = solve(i, nums, target);
//                 maxJumps = Math.max(1 + jump, maxJumps);
//             }
//         }
//         return maxJumps;
//     }
//     public int maximumJumps(int[] nums, int target) {
//         int res = solve(0, nums, target);
//         return res < 0 ? -1 : res;
//     }
// }