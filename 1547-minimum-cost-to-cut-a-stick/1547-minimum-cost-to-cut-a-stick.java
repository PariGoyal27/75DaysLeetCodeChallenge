//Recursion + memoization
class Solution {
    int[][] dp = new int[103][103];
    private int solve(int[] cuts, int l, int r) {
        if(r - l <= 1) return 0;
        int minCost = Integer.MAX_VALUE;
        if(dp[l][r] != -1) return dp[l][r];
        for(int idx = l+1; idx <= r-1; idx++){
            int cost = cuts[r] - cuts[l] + solve(cuts, l, idx) + solve(cuts, idx, r);
            minCost = Math.min(minCost, cost);
        }
        return dp[l][r] = minCost;
    }
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        Arrays.sort(cuts);
        int[] newCuts = new int[c + 2];
        newCuts[0] = 0;
        newCuts[c+1] = n; // c+2-1 = c+1
        for(int i = 0; i < c; i++){
            newCuts[i+1] = cuts[i]; 
        }
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return solve(newCuts, 0, c+1);
    }
}
//Recursion TLE -> 12 / 101
// class Solution {
//     private int solve(int[] cuts, int l, int r) {
//         if(r - l <= 1) return 0;
//         int minCost = Integer.MAX_VALUE;
//         for(int idx = l+1; idx <= r-1; idx++){
//             int cost = cuts[r] - cuts[l] + solve(cuts, l, idx) + solve(cuts, idx, r);
//             minCost = Math.min(minCost, cost);
//         }
//         return minCost;
//     }
//     public int minCost(int n, int[] cuts) {
//         int c = cuts.length;
//         Arrays.sort(cuts);
//         int[] newCuts = new int[c + 2];
//         newCuts[0] = 0;
//         newCuts[c+1] = n; // c+2-1 = c+1
//         for(int i = 0; i < c; i++){
//             newCuts[i+1] = cuts[i]; 
//         }
//         return solve(newCuts, 0, c+1);
//     }
// }