class Solution {
    //No need to take arrayList
    private int solve(int[] nums, int i, int prevIndex, int[][] dp){
        if(i == nums.length){
            return 0;
        }
        if(dp[i][prevIndex + 1] != -1) return dp[i][prevIndex + 1];

        int notTake = solve(nums, i+1, prevIndex, dp);

        int take = 0;
        if(prevIndex == -1 || nums[i] > nums[prevIndex]){
            take = 1 + solve(nums, i+1, i, dp);
        }

        return dp[i][prevIndex + 1] = Math.max(take, notTake);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        return solve(nums, 0, -1, dp);
    }
}
// My solution using recursion TLE
// class Solution {
//     private int solve(int[] nums, int i, int prev, ArrayList<Integer> list){
//         if(i == nums.length){
//             return list.size();
//         }
//         int take = 0;
//         if(nums[i] > prev){
//             list.add(nums[i]);
//             take = solve(nums, i+1, nums[i], list);
//             list.remove(list.size()-1);
//         }
//         int notTake = solve(nums, i+1, prev, list);
//         return Math.max(take, notTake);
//     }
//     public int lengthOfLIS(int[] nums) {
//         ArrayList<Integer> list = new ArrayList<>();
//         return solve(nums, 0, Integer.MIN_VALUE, list);
//     }
// }