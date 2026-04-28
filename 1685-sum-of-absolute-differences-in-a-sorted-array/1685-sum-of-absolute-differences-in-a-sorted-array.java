class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        // int[] preSum = new int[n];
        int[] ans = new int[n];
        // preSum[0] = nums[0];
        int sum = 0; // prefix Sum
        for(int i = 1; i < n; i++){
            sum += nums[i-1];
            ans[i] = i * nums[i] - sum; 
        }
        sum = 0; // Suffix Sum
        for(int i = n-2; i >= 0; i--){
            sum += nums[i+1];
            ans[i] += sum - (n-i-1) * nums[i];
        }
        
        return ans;
    }
}