class Solution {
    int n;
    int[] dp;
    private int solve(int[] arr, int d, int ind){
        int ans = 1;

        if(dp[ind] != -1) return dp[ind];

        for(int k = 1; k <= d && ind + k < n; k++){
            if(arr[ind] <= arr[ind + k]) break;
            ans = Math.max(ans, 1 + solve(arr, d, ind + k));
        }
        for(int k = 1; k <= d && ind - k >= 0; k++){
            if(arr[ind] <= arr[ind - k]) break;
            ans = Math.max(ans, 1 + solve(arr, d, ind - k));
        }
        return dp[ind] = ans;
    }
    public int maxJumps(int[] arr, int d) {
        n = arr.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        
        int cnt = 0;
        for(int i = 0; i < n; i++){
            cnt = Math.max(cnt, solve(arr, d, i));
        }
        return cnt;
    }
}