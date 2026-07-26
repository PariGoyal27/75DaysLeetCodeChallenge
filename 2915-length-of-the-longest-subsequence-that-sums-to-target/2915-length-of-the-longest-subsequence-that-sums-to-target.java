class Solution {
    Integer[][] dp;
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int sum = 0;
        int min = 1002;
        for(Integer num : nums){
            sum += num;
            min = Math.min(min, num);
        }
        if(target > sum || target < min) return -1;

        dp = new Integer[target + 1][nums.size() + 1];

        int ans = solve(nums, target, 0);
        return ans < 0 ? -1 : ans;
    }
    private int solve(List<Integer> nums, int target, int i){
        if(target < 0) return -(int)1e8;
        if(target == 0)
            return 0;
        if(i == nums.size()){
            return -(int)1e8;
        }

        if(dp[target][i] != null) return dp[target][i];

        int take = solve(nums, target - nums.get(i), i + 1);
        take = 1 + Math.max(take, -(int)1e8);

        int notTake = solve(nums, target, i + 1);

        return dp[target][i] = Math.max(take, notTake);
    }
}
// class Solution {
//     Integer[][] dp;
//     public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
//         int sum = 0;
//         int min = 1002;
//         for(Integer num : nums){
//             sum += num;
//             min = Math.min(min, num);
//         }
//         if(target > sum || target < min) return -1;

//         dp = new Integer[target + 1][nums.size()];

//         int ans = solve(nums, target, 0);
//         return ans == -(int)1e8 + 2 ? -1 : ans;
//     }
//     private int solve(List<Integer> nums, int target, int i){
//         if(i == nums.size()){
//             if(target == 0)
//                 return 0;
//             return -(int)1e8;
//         }
//         if(dp[target][i] != null) return dp[target][i];

//         int take = Integer.MIN_VALUE;
//         if(nums.get(i) <= target)
//             take = 1 + solve(nums, target - nums.get(i), i + 1);

//         int notTake = solve(nums, target, i + 1);

//         return dp[target][i] = Math.max(take, notTake);
//     }
// }