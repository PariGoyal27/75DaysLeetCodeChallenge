class Solution {
    int[][] dp;
    private int solve(int i, int j, String s1, String s2){
        if(i < 0 && j < 0) return 0;
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;

        if(dp[i][j] != -1) return dp[i][j];

        int delete = 1 + solve(i - 1, j, s1, s2);

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = Math.min(solve(i-1, j-1, s1, s2), delete);
        }else{
            int replace = 1 + solve(i-1, j-1, s1, s2);
            int insert = 1 + solve(i, j-1, s1, s2);

            return dp[i][j] = Math.min(delete, Math.min(insert, replace));
        }
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        dp = new int[m][n];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return solve(m-1, n-1, word1, word2);
    }
}