//Space Optimization
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] next = new int[n+1];
        int[] curr = new int[n+1];
        for(int i = n-1; i >= 0; i--){
            for(int prevIndex = i-1; prevIndex >= -1; prevIndex--){
                int notTake = next[prevIndex+1];

                int take = 0;
                if(prevIndex == -1 || nums[i] > nums[prevIndex]){
                    take = 1 + next[i+1];
                }

                curr[prevIndex + 1] = Math.max(take, notTake);
            }
            // for(int j = 0; j < n+1; j++){
                System.arraycopy(curr, 0, next, 0, n+1);
            // }
        }
        return next[-1+1];
    }
}
//Tabulation
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[][] dp = new int[n+1][n+1];
//         for(int i = n-1; i >= 0; i--){
//             for(int prevIndex = i-1; prevIndex >= -1; prevIndex--){
//                 int notTake = dp[i+1][prevIndex+1];

//                 int take = 0;
//                 if(prevIndex == -1 || nums[i] > nums[prevIndex]){
//                     take = 1 + dp[i+1][i+1];
//                 }

//                 dp[i][prevIndex + 1] = Math.max(take, notTake);
//             }
//         }
//         return dp[0][-1+1];
//     }
// }

// Memoization
// class Solution {
//     //No need to take arrayList
//     private int solve(int[] nums, int i, int prevIndex, int[][] dp){
//         if(i == nums.length){
//             return 0;
//         }
//         if(dp[i][prevIndex + 1] != -1) return dp[i][prevIndex + 1];

//         int notTake = solve(nums, i+1, prevIndex, dp);

//         int take = 0;
//         if(prevIndex == -1 || nums[i] > nums[prevIndex]){
//             take = 1 + solve(nums, i+1, i, dp);
//         }

//         return dp[i][prevIndex + 1] = Math.max(take, notTake);
//     }
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[][] dp = new int[n][n+1];
//         for(int[] row: dp) Arrays.fill(row, -1);
//         return solve(nums, 0, -1, dp);
//     }
// }
// My solution using recursion TLE
// class Solution {
//     private int solve(int[] nums, int i, int prev){
//         if(i == nums.length){
//             return 0;
//         }
//         int take = 0;
//         if(nums[i] > prev){
//             take = 1 + solve(nums, i+1, nums[i]);
//         }
//         int notTake = solve(nums, i+1, prev);
//         return Math.max(take, notTake);
//     }
//     public int lengthOfLIS(int[] nums) {
//         return solve(nums, 0, Integer.MIN_VALUE);
//     }
// }