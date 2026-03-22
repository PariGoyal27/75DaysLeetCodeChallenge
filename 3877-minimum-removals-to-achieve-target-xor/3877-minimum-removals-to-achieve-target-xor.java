class Solution {
    int[][] dp = new int[41][20000];
    private int solve(int[] nums, int xor, int i, int target){
        if(i == nums.length){
            if(xor == target) return 0;
            return Integer.MAX_VALUE;
        }
        
        if(dp[i][xor] != -1) return dp[i][xor];

        int take = solve(nums, xor ^ nums[i], i+1, target);
        int notTake = solve(nums, xor, i+1, target);
        if(notTake != Integer.MAX_VALUE) notTake += 1;
        int ans = Math.min(take, notTake);
        dp[i][xor] = ans;
        return ans;
    }
    public int minRemovals(int[] nums, int target) {
        int n = nums.length;
        // map.clear();
        for(int[] row : dp) Arrays.fill(row, -1);
        int ans = solve(nums, 0, 0, target);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
// Recursion + Memoization - worked
// class Solution {
//     HashMap<String, Integer> map = new HashMap<>();
//     private int solve(int[] nums, int xor, int i, int target){
//         if(i == nums.length){
//             if(xor == target) return 0;
//             return Integer.MAX_VALUE;
//         }
//         String temp = i + " " + xor;
//         if(map.containsKey(temp)) return map.get(temp);

//         int take = solve(nums, xor ^ nums[i], i+1, target);
//         int notTake = solve(nums, xor, i+1, target);
//         if(notTake != Integer.MAX_VALUE) notTake += 1;
//         int ans = Math.min(take, notTake);
//         map.put(temp, ans);
//         return ans;
//     }
//     public int minRemovals(int[] nums, int target) {
//         int n = nums.length;
//         map.clear();
//         int ans = solve(nums, 0, 0, target);
//         return ans == Integer.MAX_VALUE ? -1 : ans;
//     }
// }
// Recursion - TLE(972/1048)
// class Solution {
//     private int solve(int[] nums, int xor, int i, int target){
//         if(i == nums.length){
//             if(xor == target) return 0;
//             return Integer.MAX_VALUE;
//         }
//         int take = solve(nums, xor ^ nums[i], i+1, target);
//         int notTake = solve(nums, xor, i+1, target);
//         if(notTake != Integer.MAX_VALUE) notTake += 1;
//         return Math.min(take, notTake);
//     }
//     public int minRemovals(int[] nums, int target) {
//         int n = nums.length;
//         int ans = solve(nums, 0, 0, target);
//         return ans == Integer.MAX_VALUE ? -1 : ans;
//     }
// }