class Solution {
    private int solve(int i, int[] nums, int target){
        if(i == nums.length) {
            if(target == 0) return 1;
            return 0;
        }        

        int plus = solve(i + 1, nums, target - nums[i]);
        int minus = solve(i + 1, nums, target + nums[i]);

        return plus + minus;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int num : nums){
            total += num;
        }
        if(target < -total) return 0;


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