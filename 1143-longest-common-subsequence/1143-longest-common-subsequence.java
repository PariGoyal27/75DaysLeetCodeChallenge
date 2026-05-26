class Solution {
    int n1, n2;
    int[][] dp;
    private int solve(int i, int j, String s1, String s2){
        if(i == n1 || j == n2) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + solve(i + 1, j + 1, s1, s2);
        }
        return dp[i][j] = Math.max(solve(i + 1, j, s1, s2), solve(i, j + 1, s1, s2));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        n1 = text1.length();
        n2 = text2.length();
        dp = new int[n1][n2];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return solve(0, 0, text1, text2);
    }
}