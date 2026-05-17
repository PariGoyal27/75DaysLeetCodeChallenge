class Solution {
    
    private int solve(int[] nums, int ind, int xor){        
        if(ind == nums.length){
            return xor;
        }
        return solve(nums, ind + 1, xor ^ nums[ind]) + solve(nums, ind + 1, xor);        
    }
    public int subsetXORSum(int[] nums) {
        return solve(nums, 0, 0);
    }
}
// class Solution {
//     private int sum = 0;
//     private void solve(int[] nums, int ind, int xor){
        
//         sum += xor;
            
//         for(int i = ind; i < nums.length; i++){
//             xor = xor ^ nums[i];
//             solve(nums, i + 1, xor);
//             xor = xor ^ nums[i];
//         }
//     }
//     public int subsetXORSum(int[] nums) {
//         solve(nums, 0, 0);
//         return sum;
//     }
// }