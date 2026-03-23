//Greedy Solution
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0, jumps = 0;
        while(r < n-1){
            int farthest = 0;
            for(int i = l; i <= r; i++){
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            jumps++;
        }
        return jumps;
    }
}
//Recursion + Memoization -> TLE 97/100
// class Solution {
//     private int solve(int[] nums, int n, int reached, int jumps, int[][] dp){
//         if(reached >= n-1)
//             return jumps;
//         if(dp[reached][jumps] != -1) return dp[reached][jumps];
//         int min = Integer.MAX_VALUE;
//         for(int i = 1; i <= nums[reached]; i++){
//             min = Math.min(min, solve(nums, n, reached + i, jumps + 1, dp));
//         }
//         return dp[reached][jumps] = min;
//     }
//     public int jump(int[] nums) {
//         int n = nums.length;
//         int[][] dp = new int[n][n];
//         for(int[] row : dp)
//             Arrays.fill(row, -1);
//         return solve(nums, n, 0, 0, dp);
//     }
// }