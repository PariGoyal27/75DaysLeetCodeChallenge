class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int total = 0;
        int fn = 0;
        for(int i = 0; i < n; i++){
            total += nums[i]; 
            fn += i * nums[i]; // calculation f(0)
        }

        for(int i = 0; i < n; i++){
            int diff = total - nums[n-i-1] * n;
            fn = fn  + diff;  
            maxSum = Math.max(maxSum, fn);
        }
        return maxSum;
    }
}
// O(n^2)
// int max = Integer.MIN_VALUE;
// for(int i = 0; i < n; i++){
//     int sum = 0;
//     for(int j = 0; j < n; j++){
//         sum += nums[j] * ((j + i) % n);
//     }
//     max = Math.max(max, sum);
// }
// return max;