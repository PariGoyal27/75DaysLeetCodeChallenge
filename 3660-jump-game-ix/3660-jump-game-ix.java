class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        leftMax[0] = nums[0];
        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i-1], nums[i]);
        }
        int[] rightMin = new int[n];
        rightMin[n-1] = nums[n-1]; 
        for(int i = n-2; i>= 0; i--){
            rightMin[i] = Math.min(rightMin[i+1], nums[i]);
        }

        int[] ans = new int[n];
        ans[n-1] = leftMax[n-1];
        for(int i = n-2; i >= 0; i--){
            if(leftMax[i] <= rightMin[i+1]){
                // we do not have to go to right
                ans[i] = leftMax[i];
            }else{
                ans[i] = ans[i + 1];
            }
        }
        return ans;
    }
}
// class Solution {
//     private int solve(int[] nums, int ind, int n, boolean[] vis){
//         int ans = nums[ind];
//         vis[ind] = true;
//         // forward jumps
//         for(int j = ind + 1; j < n; j++){
//             if(nums[j] < nums[ind] && !vis[j]){
//                 ans = Math.max(ans, solve(nums, j, n));
//             }
//         }
//         // backward jumps
//         for(int j = ind - 1; j >= 0; j--){
//             if(nums[j] > ans && !vis[j]){
//                 ans = Math.max(ans, solve(nums, j, n));
//             }
//         }
//         return dp[ind] = ans;
//     }
//     public int[] maxValue(int[] nums) {
//         int n = nums.length;
//         int[] ans = new int[n];
//         for(int i = 0; i < n; i++){
//             boolean[] vis = new boolean[n];
//             ans[i] = solve(nums, i, n, vis);
//         }
//         return ans;
//     }
// }