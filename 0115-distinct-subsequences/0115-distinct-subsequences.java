class Solution {
    int[][] dp;
    private int solve(int i, int j, String s, String t){
        if(j < 0){
            return 1;
        }
        if(i < 0){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = solve(i-1, j-1, s, t) + solve(i-1, j, s, t);
        }else{
            return dp[i][j] = solve(i-1, j, s, t);
        }
    }
    public int numDistinct(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if(n2 > n1) return 0;
        dp = new int[n1][n2];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return solve(n1-1, n2-1, s, t);
    }
}