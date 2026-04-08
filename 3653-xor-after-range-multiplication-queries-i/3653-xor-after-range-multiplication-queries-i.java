class Solution {
    int MOD = (int)1e9 + 7;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long[] arr = new long[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[i] = nums[i] * 1l;
        }
        for(int i = 0; i < queries.length; i++){
            int idx = queries[i][0];
            while(idx <= queries[i][1]){
                arr[idx] = (arr[idx] * queries[i][3]) % MOD;
                idx += queries[i][2];
            }
        }
        int xor = 0;
        for(int i = 0; i < nums.length; i++){
            xor ^= arr[i];
        }
        return xor;
    }
}