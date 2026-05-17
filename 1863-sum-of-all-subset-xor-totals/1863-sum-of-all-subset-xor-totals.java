class Solution {
    private int sum = 0;
    private void solve(int[] nums, int ind, int xor){
        
        sum += xor;
            
        for(int i = ind; i < nums.length; i++){
            xor = xor ^ nums[i];
            solve(nums, i + 1, xor);
            xor = xor ^ nums[i];
        }
    }
    public int subsetXORSum(int[] nums) {
        solve(nums, 0, 0);
        return sum;
    }
}