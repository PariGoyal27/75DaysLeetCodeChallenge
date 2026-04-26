class Solution {
    public int compareBitonicSums(int[] nums) {
        int n = nums.length;
        int idx = -1;
        long sum1 = 0, sum2 = 0;
        for(int i = 0; i < n-1; i++){
            sum1 += nums[i];
            idx = i;
            if(nums[i] > nums[i+1]) break;
        }
        for(int j = idx; j < n; j++){
            sum2 += nums[j];
        }
        if(sum1 > sum2) return 0;
        if(sum1 < sum2) return 1;
        return -1;
    }
}